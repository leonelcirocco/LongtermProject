package objects.weapon;

public class WeaponAction {
	private float speedWindUp;
	private float speedAttack;
	private long durationWindUp;
	private long durationAttack;
	private float width;
	private float height;
	private int dmg;
	public WeaponAction(float speedWindup, float speedAttack, long durationWindUp, long durationAttack, float width, float height, int dmg) {
		this.speedWindUp = speedWindup;
		this.speedAttack = speedAttack;
		this.durationWindUp = durationWindUp;
		this.durationAttack = durationAttack;
		this.width = width;
		this.height=height;
		this.dmg=dmg;
	}
	public int getDmg() {
		return dmg;
	}
	public float getSpeedWindUp() {
		return speedWindUp;
	}
	public long getDurationWindUp() {
		return durationWindUp;
	}
	public float getSpeedAttack() {
		return speedAttack;
	}
	public long getDurationAttack() {
		return durationAttack;
	}
	public float getWidth() {
		return width;
	}
	public float getHeight() {
		return height;
	}
}
