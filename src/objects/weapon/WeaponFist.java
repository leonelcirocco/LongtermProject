package objects.weapon;

import java.util.ArrayList;

import org.newdawn.slick.geom.Rectangle;

import objects.base.WeaponBase;

public class WeaponFist extends WeaponBase{
	public WeaponFist() {
		name = "fist";
		dmg = 1;
		combos = new ArrayList<>();
		combos.add(new WeaponAction(0,0, 150, 100, 60, 15,1));
		combos.add(new WeaponAction(0,0, 200, 200, 90, 15,2));
		combos.add(new WeaponAction(1,0, 200, 100, 90, 10,2));
		hitbox = new Rectangle(-100, -1, 0, 0);
	}


}
