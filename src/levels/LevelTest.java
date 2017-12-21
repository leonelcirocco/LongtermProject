package levels;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import interactions.Colision;
import interactions.Gravity;
import main.Listeners;
import main.PositionLists;
import objects.Floor;
import objects.character.EnemyTest;

public class LevelTest extends BaseLevel{
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		listener = new Listeners(arg0);
		colition = new Colision(floors, objects);
		floors = new ArrayList<>();
		objects = new ArrayList<>();
		characters = new ArrayList<>();
		floors.add(new Floor(-1500, 200, 1800, 10));
		floors.add(new Floor(400, 200, 300, 10));
		characters.add(PositionLists.MAINCHARACTER_POSITION, character);
		//looteable.add(new Looteable());
		characters.add(new EnemyTest());
		//characters.add(new EnemyTest());
		characters.get(1).setX(600);
		characters.get(1).setY(100);
		//characters.get(2).setX(-700);
		//characters.get(2).setY(100);
		objects.addAll(characters);
		gravity = new Gravity();
		colision = new Colision(floors, objects);
		ID = 0;
		
	}
	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		camera.moveCamera(arg2);
		drawAll(arg2);
		for(int i=0;i<characters.size();i++){
			arg2.drawString(String.valueOf(characters.get(i).getHealthpoints()), characters.get(i).getX(), characters.get(i).getY()-60);
		}
		for(int i=0;i<looteable.size();i++){
			arg2.draw(looteable.get(i).getHitbox());
		}
	}
	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		updateCharacters();
		for(int i=0;i<objects.size();i++){
			checkGravity(objects.get(i));
			objects.get(i).update();
		}

		lootObject(arg1);
		toggleInventory(arg1);
		camera.update();
		//character.getState().update();	
	}
	
	@Override
	public int getID() {
		return ID;
	}
}
