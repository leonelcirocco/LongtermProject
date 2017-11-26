package main;

import org.newdawn.slick.GameContainer;

public class Listeners{
	private static GameContainer arg0;
	public Listeners(GameContainer arg0) {
		this.arg0 = arg0;
	}
	public static boolean upDown(){
		if(arg0.getInput().isKeyDown(Controls.UP)){
			return true;
		}
		return false;
	}
	public static boolean downDown(){
		if(arg0.getInput().isKeyDown(Controls.DOWN)){
			return true;
		}
		return false;
	}
	public static boolean rightDown(){
		if(arg0.getInput().isKeyDown(Controls.RIGHT)){
			return true;
		}
		return false;
	}
	public static boolean leftDown(){
		if(arg0.getInput().isKeyDown(Controls.LEFT)){
			return true;
		}
		return false;
	}
	public static boolean aPressed(){
		if(arg0.getInput().isKeyPressed(Controls.ACTION_A)){
			if(arg0.getInput().isKeyDown(Controls.ACTION_A)){
				return true;
			}
		}
		return false;
	}
	public static boolean bPressed(){
		if(arg0.getInput().isKeyPressed(Controls.ACTION_B)){
			if(arg0.getInput().isKeyDown(Controls.ACTION_B)){
				return true;
			}
		}
		return false;
	}
	public static boolean cPressed(){
		if(arg0.getInput().isKeyPressed(Controls.ACTION_C)){
			if(arg0.getInput().isKeyDown(Controls.ACTION_C)){
				return true;
			}
		}
		return false;
	}
	public static boolean dPressed(){
		if(arg0.getInput().isKeyPressed(Controls.ACTION_D)){
			if(arg0.getInput().isKeyDown(Controls.ACTION_D)){
				return true;
			}
		}
		return false;
	}
	public static boolean pausePressed(){
		if(arg0.getInput().isKeyPressed(Controls.PAUSE)){
			if(arg0.getInput().isKeyDown(Controls.PAUSE)){
				return true;
			}
		}
		return false;
	}
	public static boolean inventoryPressed(){
		if(arg0.getInput().isKeyPressed(Controls.INVENTORY)){
			if(arg0.getInput().isKeyDown(Controls.INVENTORY)){
				return true;
			}
		}
		return false;
	}
	public static boolean bWasPressed(){
		if(arg0.getInput().isKeyPressed(Controls.ACTION_B)){
			return true;
		}
		return false;
	}
	public static boolean aDown() {
		if(arg0.getInput().isKeyDown(Controls.ACTION_A)){
			return true;
		}
		return false;
	}
}
