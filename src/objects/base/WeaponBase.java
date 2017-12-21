package objects.base;

import java.util.ArrayList;

import org.newdawn.slick.geom.Shape;

import objects.weapon.WeaponAction;

public abstract class WeaponBase extends BaseItem{
	protected Shape hitbox;
	protected int comboNumber;
	protected int dmg;
	protected ArrayList<WeaponAction> combos;
	public WeaponBase() {
		type = "weapon";
	}
	public Shape getHitbox() {
		return hitbox;
	}
	public int getComboNumber() {
		return comboNumber;
	}
	public ArrayList<WeaponAction> getCombos() {
		return combos;
	}
	public void setHitbox(Shape hitbox) {
		this.hitbox = hitbox;
	}
	public int getDmg() {
		return dmg;
	}
	public void setDmg(int dmg) {
		this.dmg = dmg;
	}
}
