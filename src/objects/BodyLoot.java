package objects;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import objects.base.BaseItem;

public class BodyLoot extends Looteable{
	public BodyLoot(float x, float y,ArrayList<BaseItem> inventory) {
		super(x, y);
		init();
		this.inventory=inventory;
		// TODO Auto-generated constructor stub
	}
	private void init(){
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			
			@Override
			public void run() {
				delete=true;
			}
		};
		timer.schedule(timerTask, 10*1000);
	}
}
