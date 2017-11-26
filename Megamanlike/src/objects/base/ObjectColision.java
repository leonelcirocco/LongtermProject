package objects.base;

import org.newdawn.slick.geom.Shape;

public class ObjectColision extends BaseObject{
	protected Shape hitbox;
	public ObjectColision() {
	}
	public Shape getHitbox() {
		return hitbox;
	}
	public void setHitbox(Shape hitbox) {
		this.hitbox = hitbox;
	}
	public void update(){
		hitbox.setX(x);
		hitbox.setY(y);
	}
}
