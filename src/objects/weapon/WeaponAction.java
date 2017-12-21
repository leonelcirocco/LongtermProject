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
		this.speedWindUp = speedWindup; //Velocidad de movimiento del personaje durante el comienzo del ataque
		this.speedAttack = speedAttack; //velocidad de movimiento del personaje durante el ataque
		this.durationWindUp = durationWindUp; //duracion de la animacion del comienzo del ataque
		this.durationAttack = durationAttack; //duracion de la aniomacion del ataque
		this.width = width; //largo del hitbox del arma
		this.height=height; //alto del hitbox del arma
		this.dmg=dmg; //daño del arma
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
