package objects.character.states.enemies;

import org.newdawn.slick.geom.Rectangle;

import objects.base.BaseState;
import objects.character.EnemyTest;

public class EnemyMoving extends BaseState{

	public EnemyMoving(EnemyTest character) {
		super(character);
		character.setHitboxJump(new Rectangle(character.getX()+character.getHitbox().getWidth()/2, character.getY()+character.getHitbox().getHeight(), 5, 20));
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		((EnemyTest) character).move();
		//character.setX(character.getX()+character.getDirection());
		if(character.getDirection()==1){
			character.setHitboxJump(new Rectangle(character.getX(), character.getY()+character.getHitbox().getHeight(), 5, 20));	
		}else{
			character.setHitboxJump(new Rectangle(character.getX()+character.getHitbox().getWidth()/2, character.getY()+character.getHitbox().getHeight(), 5, 20));
		}
		if(((EnemyTest) character).isJump()){
			jump();
		}
		if(((EnemyTest) character).isAttack()){
			character.setState(new EnemyWindUp(character, 0));
		}
	}

}
