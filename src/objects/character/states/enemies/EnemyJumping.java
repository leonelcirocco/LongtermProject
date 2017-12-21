package objects.character.states.enemies;

import objects.base.BaseState;
import objects.base.CharacterBase;
import objects.character.EnemyTest;

public class EnemyJumping extends BaseState {

	public EnemyJumping(CharacterBase character) {
		super(character);
		character.setySpeed(-14);
		character.getGravityHitbox().setY(-1);
		character.setY(character.getY()-10);
	}

	@Override
	public void update() {
		((EnemyTest) character).move();
		stopJumping();
	}

}
