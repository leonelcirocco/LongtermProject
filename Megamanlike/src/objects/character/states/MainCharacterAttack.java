package objects.character.states;

import java.util.Timer;
import java.util.TimerTask;

import org.newdawn.slick.geom.Rectangle;

import main.Listeners;
import objects.base.CharacterBase;

public class MainCharacterAttack extends BaseStateMain{
	private int attack;
	private float xDistance = 0;
	public MainCharacterAttack(CharacterBase character, int currentAttack) {
		super(character);
		attack = currentAttack;
		character.getWeapon().setDmg(character.getWeapon().getCombos().get(currentAttack).getDmg());
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				character.getWeapon().setHitbox(new Rectangle(0,0,0,0));
				if(Listeners.bWasPressed()){
					if(character.getWeapon().getCombos().size()-1!=currentAttack){
						attack++;
					}else{
						attack=0;
					}
					character.setState(new MainCharacterWindUp(character,attack));
				}else{
					character.setState(new MainCharacterStill(character));
				}
			}
		};
		timer.schedule(task, character.getWeapon().getCombos().get(currentAttack).getDurationAttack());
		if(character.getDirection()==-1){
			xDistance=-character.getWeapon().getCombos().get(currentAttack).getWidth();
		}
	}

	@Override
	public void update() {
		character.setX(character.getX()+character.getWeapon().getCombos().get(attack).getSpeedAttack()*character.getDirection());
		character.getWeapon().setHitbox(new Rectangle(character.getX()+character.getHitbox().getWidth()/2+xDistance, character.getY(),
				character.getWeapon().getCombos().get(attack).getWidth(),
				character.getWeapon().getCombos().get(attack).getHeight()));
	}

}
