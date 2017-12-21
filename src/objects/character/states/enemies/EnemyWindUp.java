package objects.character.states.enemies;

import java.util.Timer;
import java.util.TimerTask;

import objects.base.CharacterBase;
import objects.character.states.main.BaseStateMain;

public class EnemyWindUp extends BaseStateMain{
	private int currentAttack;
	public EnemyWindUp(CharacterBase character, int currentAttack) {
		super(character);
		this.currentAttack=currentAttack;
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				character.setState(new EnemyAttacking(character,currentAttack));
			}
		};
		timer.schedule(task, character.getWeapon().getCombos().get(currentAttack).getDurationWindUp());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		character.setX(character.getX()+character.getWeapon().getCombos().get(currentAttack).getSpeedWindUp()*character.getDirection());
	}

}
