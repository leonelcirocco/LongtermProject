package objects.base;

import objects.character.EnemyTest;
import objects.character.states.enemies.EnemyJumping;
import objects.character.states.enemies.EnemyMoving;

public abstract class BaseState {
	protected CharacterBase character;
	public BaseState(CharacterBase character) {
		this.character=character;
		// TODO Auto-generated constructor stub
	}
	public abstract void update();
	
	public void move(float x, float y){
		
	}
	public void jump(){
		character.setySpeed(-10);
		character.setState(new EnemyJumping(character));
	}
	public void stopJumping(){
		if(character.getySpeed()==0){
			character.setState(new EnemyMoving((EnemyTest) character));
		}
	}

}
