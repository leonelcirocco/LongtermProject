package interactions;

import org.newdawn.slick.Graphics;

import objects.base.CharacterBase;

public class Camera {
	private CharacterBase character;
	private float x;
	private float y;
	private float cameraSpeed=25;
	private float xRight = 200;
	private float xLeft = 550;
	private int direction = 1;
	private boolean turn = false;
	public Camera(CharacterBase character) {
		this.character = character;
		x=character.getX()-xRight;
		// TODO Auto-generated constructor stub
	}
	public void moveCamera(Graphics arg2){

		arg2.translate(-x, -y);
	}
	public void update(){
		cameraTurn();
		if(!turn){
			cameraFollow();
		}
	}
	private void cameraFollow(){
		y=character.getY()-300;
		if(character.getDirection()==1){
			x=character.getX()-xRight;
		}else{
			x=character.getX()-xLeft;
		}
	}
	private void cameraTurn(){
		y=character.getY()-300;
		if(direction!=character.getDirection()){
			turn=true;
		}
		if(turn){
			x=x+cameraSpeed*character.getDirection();
			if(check()){
				turn = false;
				direction = -direction;
			}
		}
	}
	private boolean check(){
		if(character.getDirection()==1){
			if(x<character.getX()-xRight+cameraSpeed*2&&x>character.getX()-xRight - cameraSpeed*2){
				return true;
			}
		}else{
			if(x<character.getX()-xLeft+cameraSpeed*2&&x>character.getX()-xLeft-cameraSpeed*2){
				return true;
			}
		}
		return false;
	}
}
