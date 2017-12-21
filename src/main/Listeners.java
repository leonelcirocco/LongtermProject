package main;

import org.newdawn.slick.GameContainer;

public class Listeners{
	private static GameContainer arg0;
	public Listeners(GameContainer arg0) {
		Listeners.arg0 = arg0;
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
	public static boolean rightBumperDown(){
		if(arg0.getInput().isKeyDown(Controls.RIGHT_BUMPER)){
			return true;
		}
		return false;
	}
	public static boolean rightTriggerDown(){
		if(arg0.getInput().isKeyDown(Controls.RIGHT_TRIGGER)){
			return true;
		}
		return false;
	}
	public static boolean leftBumperDown(){
		if(arg0.getInput().isKeyDown(Controls.LEFT_BUMPER)){
			return true;
		}
		return false;
	}
	public static boolean leftTriggerDown(){
		if(arg0.getInput().isKeyDown(Controls.RIGHT_TRIGGER)){
			return true;
		}
		return false;
	}
	public static boolean rightBumperPressed(){
		if(arg0.getInput().isKeyPressed(Controls.RIGHT_BUMPER)){
			if(arg0.getInput().isKeyDown(Controls.RIGHT_BUMPER)){
				return true;
			}
		}
		return false;
	}

	public static boolean rightTriggerPressed(){
		if(arg0.getInput().isKeyPressed(Controls.RIGHT_TRIGGER)){
			if(arg0.getInput().isKeyDown(Controls.RIGHT_TRIGGER)){
				return true;
			}
		}
		return false;
	}

	public static boolean leftBumperPressed(){
		if(arg0.getInput().isKeyPressed(Controls.LEFT_BUMPER)){
			if(arg0.getInput().isKeyDown(Controls.LEFT_BUMPER)){
				return true;
			}
		}
		return false;
	}

	public static boolean leftTriggerPressed(){
		if(arg0.getInput().isKeyPressed(Controls.LEFT_TRIGGER)){
			if(arg0.getInput().isKeyDown(Controls.LEFT_TRIGGER)){
				return true;
			}
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
		if(arg0.getInput().isKeyPressed(Controls.ACTION_Y)){
			if(arg0.getInput().isKeyDown(Controls.ACTION_Y)){
				return true;
			}
		}
		return false;
	}
	public static boolean dPressed(){
		if(arg0.getInput().isKeyPressed(Controls.ACTION_X)){
			if(arg0.getInput().isKeyDown(Controls.ACTION_X)){
				return true;
			}
		}
		return false;
	}
	public static boolean pausePressed(){
		if(arg0.getInput().isKeyPressed(Controls.START)){
			if(arg0.getInput().isKeyDown(Controls.START)){
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

	public static boolean dDown() {
		if(arg0.getInput().isKeyDown(Controls.ACTION_X)){
			return true;
		}
		return false;
	}
	public static boolean downPressed() {
		if(arg0.getInput().isKeyPressed(Controls.DOWN)){
			if(arg0.getInput().isKeyDown(Controls.DOWN)){
				return true;
			}
		}
		return false;
	}
	public static boolean upPressed() {
		if(arg0.getInput().isKeyPressed(Controls.UP)){
			if(arg0.getInput().isKeyDown(Controls.UP)){
				return true;
			}
		}
		return false;
	}
}
