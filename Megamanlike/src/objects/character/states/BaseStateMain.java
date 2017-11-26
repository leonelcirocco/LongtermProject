package objects.character.states;

import main.Listeners;
import objects.base.BaseState;
import objects.base.CharacterBase;

public abstract class BaseStateMain extends BaseState{

	public BaseStateMain(CharacterBase character) {
		super(character);
		// TODO Auto-generated constructor stub
	}
	protected void move(){
		if(Listeners.leftDown()){
			character.setDirection(-1);
			character.setX(character.getX()-character.getSpeed());
		}
		if(Listeners.rightDown()){
			character.setDirection(1);
			character.setX(character.getX()+character.getSpeed());
		}
	}
	protected void jump(){
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
