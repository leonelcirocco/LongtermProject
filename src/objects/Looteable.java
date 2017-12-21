package objects;

import java.util.ArrayList;

import org.newdawn.slick.geom.Rectangle;

import objects.base.BaseItem;
import objects.base.ObjectColision;
import objects.items.ItemTest;

public class Looteable extends ObjectColision{
	protected boolean delete = false;
	protected ArrayList<BaseItem> inventory;
	public Looteable(float x, float y) {
		this.x=x;
		this.y=y;
		hitbox = new Rectangle(x, y, 10, 10);
		inventory = new ArrayList<>();
		inventory.add(new ItemTest());
	}
	public ArrayList<BaseItem> getInventory() {
		return inventory;
	}
	public boolean isDelete() {
		return delete;
	}
}
