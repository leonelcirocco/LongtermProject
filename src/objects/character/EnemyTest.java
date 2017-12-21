package objects.character;

import java.util.ArrayList;

import org.newdawn.slick.geom.Rectangle;

import objects.base.CharacterBase;
import objects.character.states.enemies.EnemyMoving;
import objects.weapon.WeaponTest;

public class EnemyTest extends CharacterBase{
	protected boolean jump = false;
	protected boolean attack = false;
	protected float currentSpeed = 0;
	public EnemyTest() {
		speed=2;
		state = new EnemyMoving(this);
		hitboxJump = new Rectangle(x, y, 100, 10);
		recoveryDuration = 300;
		inventory = new ArrayList<>();
		inventory.add(new WeaponTest());
	}
	public boolean isAttack() {
		return attack;
	}
	public void setAttack(boolean attack) {
		this.attack = attack;
	}
	public boolean isJump() {
		return jump;
	}
	public void setJump(boolean jump) {
		this.jump = jump;
	}
	public void move(){
		currentSpeed=speed*direction;
		x=x+currentSpeed;
	}

}
