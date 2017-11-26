package objects.base;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;


public class ObjectGravity extends ObjectColision{
	protected Shape gravityHitbox;
	protected float ySpeed = 0;
	protected float xGravity;
	protected float yGravity;
	protected float widthGravity = 10;
	public ObjectGravity() {
		gravityHitbox = new Rectangle(0, 0, 10, 0);
	}
	public Shape getGravityHitbox() {
		return gravityHitbox;
	}
	public void setGravityHitbox(Shape gravityHitbox) {
		this.gravityHitbox = gravityHitbox;
	}
	public float getxGravity() {
		return xGravity;
	}
	public float getyGravity() {
		return yGravity;
	}
	public float getWidthGravity() {
		return widthGravity;
	}
	public void setyGravity(float yGravity) {
		this.yGravity = yGravity;
	}
	public void update(){
		y=y+ySpeed;
		hitbox.setY(y);
		xGravity=x;
		yGravity=y+hitbox.getHeight();
	}
	public float getySpeed() {
		return ySpeed;
	}
	public void setySpeed(float ySpeed) {
		this.ySpeed = ySpeed;
	}
}
