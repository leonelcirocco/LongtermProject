package interactions;

import org.newdawn.slick.geom.Rectangle;

import objects.base.ObjectGravity;

public class Gravity {
	private float speed = 0;
	private float gravitySpeed = 0.6f;
	public Gravity() {
	}
	public void fall(ObjectGravity object){
		speed = object.getySpeed() + gravitySpeed;
		object.setySpeed(speed);
		object.setY(object.getY()+object.getySpeed());
		object.setGravityHitbox(new Rectangle(object.getxGravity(), object.getyGravity()+object.getySpeed()+1, object.getWidthGravity(), object.getySpeed()));
	}
	public void stopFall(ObjectGravity object){
			speed = 0;
			object.setySpeed(0);
			object.setGravityHitbox(new Rectangle(object.getxGravity(), object.getyGravity(), object.getWidthGravity(), speed));
		
	}
	public float getSpeed() {
		return speed;
	}
}
