package min.hearthstone.character;

import java.util.EnumSet;

public class Jaina extends CharacterImpl{

	public Jaina() {
		this.setAttack(0);
		this.setShield(0);
		this.setVitality(30);
		this.setHeroName("jaina");
		this.setFirstGreeting("반가워요");
		this.setJob(CharacterJob.MAGE);
		this.setState(CharacterState.NORMAL);
		EnumSet<Secret> enumSet = EnumSet.noneOf(Secret.class);
		this.setSecret(enumSet);
	}

	@Override
	public boolean heroSpecialAction() {
		// TODO Auto-generated method stub
		return false;
	}
}
