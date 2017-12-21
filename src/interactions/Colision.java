package interactions;

import java.util.ArrayList;

import objects.base.ObjectColision;
import objects.base.ObjectGravity;
import objects.base.WeaponBase;

public class Colision {
	ArrayList<ObjectColision> floors;
	ArrayList<ObjectGravity> characters;
	public Colision(ArrayList<ObjectColision> floors,ArrayList<ObjectGravity> characters) {
		this.floors = floors;
		this.characters = characters;
	}
	public int colitionGravity(ObjectGravity character){
		for(int i=0;i<floors.size();i++){ //Se fija si el personaje "character" colisiona con cualquier piso
			if(character.getGravityHitbox().intersects(floors.get(i).getHitbox())){
				return i; //Colisiona con algun piso
			}
		}
		return -1; //No colisiona
	}
	public boolean colitionCharacter(ObjectGravity character){
		for(int i=0;i<characters.size();i++){
			if(character.getGravityHitbox().intersects(characters.get(i).getHitbox())){
				return true;
			}
		}
		return false;
	}
	public boolean colitionWeapon(WeaponBase weapon){
		for(int i=0;i<characters.size();i++){
			if(weapon.getHitbox().intersects(characters.get(i).getHitbox())){
				return true;
			}
		}
		return false;
	}
}
