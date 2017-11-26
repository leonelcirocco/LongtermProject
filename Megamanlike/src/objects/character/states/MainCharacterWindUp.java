package objects.character.states;

import java.util.Timer;
import java.util.TimerTask;

import objects.base.CharacterBase;

public class MainCharacterWindUp extends BaseStateMain{
	private int currentAttack;
	public MainCharacterWindUp(CharacterBase character, int currentAttack) {
		super(character);
		this.currentAttack=currentAttack;
		System.out.println("wind up");
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				character.setState(new MainCharacterAttack(character,currentAttack));
			}
		};
		timer.schedule(task, character.getWeapon().getCombos().get(currentAttack).getDurationWindUp());
	}

	@Override
	public void update() {
		character.setX(character.getX()+character.getWeapon().getCombos().get(currentAttack).getSpeedWindUp()*character.getDirection());
	}

}
