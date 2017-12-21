package objects.character;

import objects.base.CharacterBase;
import objects.base.WeaponBase;
import objects.character.states.main.MainCharacterStill;
import objects.weapon.WeaponFist;

public class MainCharacter extends CharacterBase{
	public MainCharacter() {
		speed=5;
		state = new MainCharacterStill(this);
		weapon = new WeaponFist();
	}
	public void changeWeapon(WeaponBase weapon){
		inventory.remove(weapon);
		inventory.add(this.weapon);
		this.weapon = weapon;
	}
}
