package objects.items.armour;

import objects.base.BaseItem;

public abstract class BaseArmour extends BaseItem implements Equipable{
	private int value = 0;
	
	public int getValue() {
		return value;
	}
}
