package levels;

import java.util.ArrayList;


import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import interactions.Camera;
import interactions.Colision;
import interactions.Gravity;
import main.Listeners;
import objects.BodyLoot;
import objects.Looteable;
import objects.base.CharacterBase;
import objects.base.ObjectColision;
import objects.base.ObjectGravity;
import objects.base.WeaponBase;
import objects.character.EnemyTest;
import objects.character.MainCharacter;
import objects.character.states.enemies.EnemyMoving;
import objects.character.states.enemies.EnemyStill;
import objects.character.states.main.MainCharacterFalling;
import objects.character.states.main.MainCharacterStill;

public abstract class BaseLevel extends BasicGameState{
	protected ArrayList<ObjectColision>floors = new ArrayList<>();
	protected ArrayList<ObjectGravity>objects = new ArrayList<>();
	protected ArrayList<CharacterBase>characters = new ArrayList<>();
	protected static MainCharacter character = new MainCharacter();
	public static Listeners listener;
	protected Colision colition;
	protected Gravity gravity;
	protected Colision colision;
	protected Camera camera = new Camera(character);
	protected ArrayList<Looteable> looteable = new ArrayList<>();
	protected int ID;
	protected static int currentID = 1;
	
	protected void hit(int dmg, CharacterBase character){
		character.setHealthpoints(character.getHealthpoints()-dmg); //Sacar vida del personaje "character"
	}
	protected boolean checkLive(CharacterBase character){ //Se fija si murio el personaje "character"
		if(character.getHealthpoints()<=0){
			return false;
		}
		return true;
	}
	protected int checkHit(WeaponBase weapon){ //Se fija si el arma colisiona con otro personaje que no sea el personaje que realiza el atauqe
		for(int i=0; i<characters.size();i++){
			if(weapon!=characters.get(i).getWeapon()){
				if((characters.get(i).getHitbox().intersects(weapon.getHitbox()))){
					return i;
				}
			}
		}
		return -1;
	}
	protected void deleteCorpses(){
		for(int i=0;i<looteable.size();i++){
			if(looteable.get(i).isDelete()){
				looteable.remove(i);
				i--;
			}
		}
	}
	protected void updateCharacters(){
		for(int i=0;i<characters.size();i++){
			if(!characters.get(i).isGotHit()){ //Si no ha sido golpeado el personaje
				if(characters.get(i).getClass().equals(EnemyTest.class)){
					checkView((EnemyTest)characters.get(i));
					checkDistance((EnemyTest) characters.get(i));
					checkEnemyDirection((EnemyTest) characters.get(i));
					checkLedge((EnemyTest) characters.get(i));
				}
				characters.get(i).getState().update();
				if(checkHit(characters.get(i).getWeapon())!=-1){
					characters.get(checkHit(characters.get(i).getWeapon())).getHit(10);
				}
				if(!checkLive(characters.get(i))){
					looteable.add(new BodyLoot(characters.get(i).getX(),characters.get(i).getY(),characters.get(i).getInventory()));
					objects.remove(characters.get(i));
					characters.remove(i);
				}
			}
		}
		
	}
	private void checkView(EnemyTest character) {
		if(Math.abs(character.getX()-BaseLevel.character.getX())<character.getFieldVision()){
			if(character.getState().getClass().equals(EnemyStill.class)){
			character.setState(new EnemyMoving(character));
			}
		}else{
			if(!character.getState().getClass().equals(EnemyStill.class)){
				character.setState(new EnemyStill(character));
			}
		}
	}
	protected void checkGravity(ObjectGravity character){
		if(colision.colitionGravity(character)==-1){//No colisiona con el piso
			gravity.fall(character);//persoaje "character" empieza a caer
			if(character.getClass().equals(MainCharacter.class)){
				if(!BaseLevel.character.getState().getClass().equals(MainCharacterFalling.class)){ //Si "character" es el jugador cambia de estado
					BaseLevel.character.setState(new MainCharacterFalling(BaseLevel.character));
				}
			}
		}else{//Si colisiona con el piso
			character.setY(floors.get(colision.colitionGravity(character)).getY()-character.getHitbox().getHeight()); //El personaje se pone en las coordenadas adecuadas
			gravity.stopFall(character);//El personaje pierde toda velocidad de gravedad
			if(character.getClass().equals(MainCharacter.class)){
				if(BaseLevel.character.getState().getClass().equals(MainCharacterFalling.class)){//Si "character" es el jugador, cambia de estado
					BaseLevel.character.setState(new MainCharacterStill(BaseLevel.character));
				}
			}else{
				//character.setySpeed(0);
			}
		}
	}
	protected void drawAll(Graphics arg2){
		for(int i=0;i<floors.size();i++){
			arg2.draw(floors.get(i).getHitbox());
		}
		for(int i=0;i<objects.size();i++){
			arg2.draw(objects.get(i).getGravityHitbox());
			arg2.draw(objects.get(i).getHitbox());
		}
		//arg2.draw(characters.get(1).getHitboxJump());
		drawWeapons(arg2);
	}
	protected void drawWeapons(Graphics arg2){
		for(int i=0;i<characters.size();i++){
			arg2.draw(characters.get(i).getWeapon().getHitbox());
		}
	}
	protected void checkLedge(EnemyTest character){
		boolean jump = true;
		for(int i=0;i<floors.size();i++){
			if(character.getHitboxJump().intersects(floors.get(i).getHitbox())){ //Si no tiene piso adelante el enemigo "character" salta
				jump = false;
			}
		}
		character.setJump(jump);
	}
	protected void checkEnemyDirection(EnemyTest character){
		if(character.getX()<BaseLevel.character.getX()){ //Cambia la direccion del personaje "character"
			character.setDirection(1);;	
		}else{
			character.setDirection(-1);
		}
	}
	protected void checkDistance(EnemyTest character){
		if(Math.abs(character.getX()-BaseLevel.character.getX())<character.getWeapon().getCombos().get(0).getWidth()){ //Se fija si esta al alcance del arma del personaje principal
			character.setAttack(true);
		}else{
			character.setAttack(false);
		}
	}
	protected void toggleInventory(StateBasedGame arg1){
		if(Listeners.inventoryPressed()){ //Entra al inventario
			Inventory.inventory=character.getInventory();
			arg1.enterState(currentID);
			currentID = ID;
		}
	}
	protected void lootObject(StateBasedGame arg1){
		if(Listeners.cPressed()){
			for(int i=0;i<looteable.size();i++){
				if(character.getHitbox().intersects(looteable.get(i).getHitbox())){
					if(looteable.get(i).getInventory().size()>0){
						Inventory.inventory=looteable.get(i).getInventory();
						arg1.enterState(currentID);
						currentID=ID;
					}
				}
			}
		}
	}
}
