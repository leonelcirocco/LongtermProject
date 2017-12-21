package levels;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import main.Listeners;
import objects.base.BaseItem;
import objects.base.WeaponBase;
import objects.items.armour.BaseArmour;
import objects.items.armour.Equipable;

public class Inventory extends BaseLevel{
	private float cursorX = 0;
	private float cursorY = 20;
	public static ArrayList<BaseItem>inventory;
	private int currentPosition = 0;
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		ID = 1;
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		/*for(int i=0;i<character.getInventory().size();i++){ //Dibujar el nombre de todos los items
			arg2.drawString(character.getInventory().get(i).getName(), 10, 20*(i+2));
		}*/
		for(int i=0;i<inventory.size();i++){
			arg2.drawString(inventory.get(i).getName(), 10, 20*(i+2));
		}
		arg2.drawRect(cursorX, cursorY*(currentPosition+2), 10, 10); //Dibujar el cursor
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		toggleInventory(arg1);
		useCursor(arg1);
		if(Listeners.cPressed()){
			arg1.enterState(currentID);
			currentID = ID;
		}
	}
	private void useCursor(StateBasedGame arg1){
		if(Listeners.downPressed()){ //Mover hacia abajo el cursor
			if(currentPosition</*character.getInventory().size()*/inventory.size()-1){
				currentPosition++;
			}else{
				currentPosition=0;
			}
		}
		if(Listeners.upPressed()){ //Mover hacia arriba el cursor
			if(currentPosition>0){
				currentPosition--;
			}else{
				currentPosition=/*character.getInventory().size()*/inventory.size()-1;
			}
		}
		if(Listeners.aPressed()){ //Usar el item del cursor
			if(character.getInventory().equals(inventory)){//Si es el inventario del personaje
				if(character.getInventory().size()==0){//Si el inventario esta vacio no hace nada
					return;
				}
				if(character.getInventory().get(currentPosition) instanceof Equipable){
					character.autoEquip((BaseArmour) character.getInventory().get(currentPosition));
					return;
				}
				if(character.getInventory().get(currentPosition).getType()=="weapon"){
					character.changeWeapon((WeaponBase) character.getInventory().get(currentPosition));
				}
			}else{//Si es un contenedor
				character.getInventory().add(inventory.get(currentPosition));
				inventory.remove(currentPosition);
				if(inventory.size()==0){
					arg1.enterState(currentID);
					currentID = ID;
				}
			}
		}
	}
	@Override
	public int getID() {
		return 1;
	}

}
