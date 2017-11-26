package objects.base;

public abstract class BaseState {
	protected CharacterBase character;
	public BaseState(CharacterBase character) {
		this.character=character;
		// TODO Auto-generated constructor stub
	}
	public abstract void update();

}
