package objects.character.states;

import objects.base.CharacterBase;

public class MainCharacterStill extends BaseStateMain{

	public MainCharacterStill(CharacterBase character) {
		super(character);
		
	}

	@Override
	public void update() {
		jump();
		attack();
		move();
	}

}
