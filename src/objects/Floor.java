package objects;

import org.newdawn.slick.geom.Rectangle;

import objects.base.ObjectColision;

public class Floor extends ObjectColision{
	public Floor(float x, float y, float width, float height) {
		this.x=x;
		this.y=y;
		hitbox = new Rectangle(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
}
