package objects.character;

import objects.base.CharacterBase;
import objects.character.states.MainCharacterStill;
import objects.weapon.WeaponTest;

public class MainCharacter extends CharacterBase{
	public MainCharacter() {
		state = new MainCharacterStill(this);
		weapon = new WeaponTest();
	}
}
