package objects.character.states.enemies;

import org.newdawn.slick.geom.Rectangle;

import objects.base.BaseState;
import objects.base.CharacterBase;

public class EnemyStill extends BaseState{

	public EnemyStill(CharacterBase character) {
		super(character);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		character.setHitboxJump(new Rectangle(character.getX()+character.getHitbox().getWidth()/2, character.getY()+character.getHitbox().getHeight(), 5, 20));
		
	}

}
