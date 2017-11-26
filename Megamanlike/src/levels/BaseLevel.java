package levels;

import java.util.ArrayList;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import interactions.Colision;
import interactions.Gravity;
import main.Listeners;
import main.PositionLists;
import objects.Floor;
import objects.base.CharacterBase;
import objects.base.ObjectColision;
import objects.base.ObjectGravity;
import objects.base.WeaponBase;
import objects.character.MainCharacter;
import objects.character.states.MainCharacterFalling;
import objects.character.states.MainCharacterStill;

public class BaseLevel extends BasicGameState{
	protected ArrayList<ObjectColision>floors;
	protected ArrayList<ObjectGravity>objects;
	protected ArrayList<CharacterBase>characters;
	protected MainCharacter character;
	public static Listeners listener;
	protected Colision colition;
	protected Gravity gravity;
	protected Colision colision;
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		listener = new Listeners(arg0);
		colition = new Colision(floors, objects);
		floors = new ArrayList<>();
		objects = new ArrayList<>();
		characters = new ArrayList<>();
		floors.add(new Floor(0, 200, 300, 10));
		character = new MainCharacter();
		characters.add(PositionLists.MAINCHARACTER_POSITION, character);
		characters.add(new CharacterBase());
		characters.get(1).setX(100);
		objects.addAll(characters);
		gravity = new Gravity();
		colision = new Colision(floors, objects);
		
	}
	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		drawAll(arg2);
	}
	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		for(int i=0;i<characters.size();i++){
			if(checkHit(characters.get(i).getWeapon())!=-1){
				characters.get(checkHit(characters.get(i).getWeapon())).getHit(10);
			}
		}
		for(int i=0;i<objects.size();i++){
			checkGravity(objects.get(i));
			objects.get(i).update();
		}
		character.getState().update();
		System.out.println(characters.get(1).getHealthpoints());
	}
	@Override
	public int getID() {
		return 0;
	}
	protected void hit(int dmg, CharacterBase character){
		character.setHealthpoints(character.getHealthpoints()-dmg);
	}
	protected int checkHit(WeaponBase weapon){
		for(int i=0; i<characters.size();i++){
			if(weapon!=characters.get(i).getWeapon()){
				if((characters.get(i).getHitbox().intersects(weapon.getHitbox()))){
					return i;
				}
			}
		}
		return -1;
	}
	protected void checkGravity(ObjectGravity character){
		if(colision.colitionGravity(character)==-1){
			gravity.fall(character);
			if(character.getClass().equals(MainCharacter.class)){
				if(!this.character.getState().getClass().equals(MainCharacterFalling.class)){
					this.character.setState(new MainCharacterFalling(this.character));
				}
			}
		}else{
			character.setY(floors.get(colision.colitionGravity(character)).getY()-character.getHitbox().getHeight());
			gravity.stopFall(character);
			if(character.getClass().equals(MainCharacter.class)){
				if(this.character.getState().getClass().equals(MainCharacterFalling.class)){
					this.character.setState(new MainCharacterStill(this.character));
				}
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
		drawWeapons(arg2);
	}
	protected void drawWeapons(Graphics arg2){
		for(int i=0;i<characters.size();i++){
			arg2.draw(characters.get(i).getWeapon().getHitbox());
		}
	}
	protected void checkDeath(){
		
	}
}
