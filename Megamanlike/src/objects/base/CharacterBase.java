package objects.base;

import java.util.Timer;
import java.util.TimerTask;

import org.newdawn.slick.geom.Rectangle;

import objects.weapon.WeaponTest;

public class CharacterBase extends ObjectGravity{
	protected float speed = 3;
	protected int direction;
	protected boolean recoveryTime = true;
	protected int recoveryDuration = 200;
	protected int healthpoints = 100;
	protected BaseState state;
	protected WeaponBase weapon;
	public CharacterBase() {
		hitbox = new Rectangle(0, 0, 20, 20);
		weapon = new WeaponTest();
	}
	public void update(){
		super.update();
		hitbox.setX(x);
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public float getSpeed() {
		return speed;
	}
	public BaseState getState() {
		return state;
	}
	public void setState(BaseState state) {
		this.state = state;
	}
	public WeaponBase getWeapon() {
		return weapon;
	}
	public void setWeapon(WeaponBase weapon) {
		this.weapon = weapon;
	}
	public int getHealthpoints() {
		return healthpoints;
	}
	public void setHealthpoints(int healthpoints) {
		this.healthpoints = healthpoints;
	}
	public void getHit(int dmg) {
		if(recoveryTime){
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				
				@Override
				public void run() {
					recoveryTime=true;
				}
			};
			timer.schedule(task, recoveryDuration);
			recoveryTime=false;
			healthpoints=healthpoints-dmg;
		}
	}
}