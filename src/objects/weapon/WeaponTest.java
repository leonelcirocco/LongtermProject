package objects.weapon;

import java.util.ArrayList;

import org.newdawn.slick.geom.Rectangle;

import objects.base.WeaponBase;

public class WeaponTest extends WeaponBase{
	public WeaponTest() {
		name = "weaponTest";
		dmg = 1;
		combos = new ArrayList<>();
		combos.add(new WeaponAction(0,3, 550, 100, 60, 15,1));
		combos.add(new WeaponAction(1,0, 300, 100, 90, 15,2));
		combos.add(new WeaponAction(-2,0, 300, 100, 90, 10,2));
		combos.add(new WeaponAction(0,0, 200, 100, 40, 10,4));
		hitbox = new Rectangle(-100, -1, 0, 0);
	}

}
