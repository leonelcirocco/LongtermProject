package objects.base;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import objects.items.armour.BaseArmour;
import objects.weapon.WeaponTest;

public class CharacterBase extends ObjectGravity{
	protected float speed = 3;
	protected int direction;
	protected Shape hitboxJump;
	protected boolean recoveryTime = true;
	protected int recoveryDuration = 200;
	protected int healthpoints = 100;
	protected BaseState state;
	protected WeaponBase weapon;
	protected ArrayList<BaseItem> inventory;
	protected boolean gotHit = false;
	protected BaseArmour[] armour;
	protected float fieldVision = 600;
	public CharacterBase() {
		hitbox = new Rectangle(0, 0, 30, 80);
		weapon = new WeaponTest();
		inventory = new ArrayList<>();
		armour = new BaseArmour[9];
	}
	public float getFieldVision() {
		return fieldVision;
	}
	public ArrayList<BaseItem> getInventory() {
		return inventory;
	}
	public boolean isGotHit() {
		return gotHit;
	}
	public void setGotHit(boolean gotHit) {
		this.gotHit = gotHit;
	}
	public BaseArmour[] getArmour() {
		return armour;
	}
	public void update(){
		super.update();
		hitbox.setX(x);
	}
	public Shape getHitboxJump() {
		return hitboxJump;
	}
	public void setHitboxJump(Shape hitboxJump) {
		this.hitboxJump = hitboxJump;
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
			gotHit=true;
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					recoveryTime=true;
					gotHit=false;
				}
			};
			timer.schedule(task, recoveryDuration);
			recoveryTime=false;
			healthpoints=healthpoints-dmg;
		}
	}
	public void autoEquip(BaseArmour armour){
		switch (armour.getArmourSlot()) {
		case "helm":
			equip(0,armour);
			break;
		case "torso":
			equip(1,armour);
			break;
		case "rShoulder":
			equip(2,armour);
			break;
		case "lShoulder":
			equip(3,armour);
			break;
		case "rArm":
			equip(4,armour);
			break;
		case "lArm":
			equip(5,armour);
			break;
		case "rHand":
			equip(6,armour);
			break;
		case "lHand":
			equip(7,armour);
			break;
		case "rBoot":
			equip(8,armour);
			break;
		case "lBoot":
			equip(9,armour);
			break;
		}
	}
	private void equip(int i, BaseArmour armour){
		if(this.armour[i]!=null){
			inventory.add(this.armour[i]);
		}
		this.armour[i]=armour;
		inventory.remove(armour);
	}
}