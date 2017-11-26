package objects.base;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

public class BaseObject {
	protected float x;
	protected float y;
	protected SpriteSheet spriteSheet;
	protected Animation animation;
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public SpriteSheet getSpriteSheet() {
		return spriteSheet;
	}
	public void setSpriteSheet(SpriteSheet spriteSheet) {
		this.spriteSheet = spriteSheet;
	}
	public Animation getAnimation() {
		return animation;
	}
	public void setAnimation(Animation animation) {
		this.animation = animation;
	}
	public void draw(){
		animation.draw(x, y);
	}
}
