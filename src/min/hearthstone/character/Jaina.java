package min.hearthstone.character;

public class Jaina extends CharacterImpl{

	public Jaina() {
		this.setVitality(30);
		this.setHeroName("jaina");
		this.setFirstGreeting("반가워요");
		this.setJob(CharacterJob.MAGE);
		this.setState(CharacterState.NORMAL);
	}

	@Override
	public boolean heroSpecialAction() {
		// TODO Auto-generated method stub
		return false;
	}
}
