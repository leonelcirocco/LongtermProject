package objects.character.states.main;

import main.Listeners;
import objects.base.BaseState;
import objects.base.CharacterBase;

public abstract class BaseStateMain extends BaseState{

	public BaseStateMain(CharacterBase character) {
		super(character);
	}
	protected void move(){
		float speed = character.getSpeed();
		if(Listeners.dDown()){
			speed=speed*3/2;
		}
		if(Listeners.leftDown()){
			character.setDirection(-1);
			character.setX(character.getX()-speed);
		}
		if(Listeners.rightDown()){
			character.setDirection(1);
			character.setX(character.getX()+speed);
		}
	}
	public void jump(){
		if(Listeners.aPressed()){
			character.setyGravity(0);
			character.setySpeed(-9);
			character.getGravityHitbox().setY(-1);
		}
	}
	protected void stopJump(){
		if(character.getySpeed()<-2){
			if(!Listeners.aDown()){
				character.setySpeed(-2);
			}
		}
	}
	protected void attack(){
		if(Listeners.bPressed()){
			character.setState(new MainCharacterWindUp(character,0));
		}
	}

}
