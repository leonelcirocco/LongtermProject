package objects.character.states.main;

import objects.base.CharacterBase;

public class MainCharacterFalling extends BaseStateMain{

	public MainCharacterFalling(CharacterBase character) {
		super(character);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		move();
		stopJump();
	}
}
