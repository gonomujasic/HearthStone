package min.hearthstone.character;

import java.util.EnumSet;

import min.hearthstone.game.GameInfo;

public abstract class CharacterImpl implements Character {

	private int vitality;
	private int attack;
	private int shield;
	private String heroName;
	private String firstGreeting;
	private Enum<CharacterJob> job;
	private Enum<CharacterState> state;
	private EnumSet<Secret> secret;
	
	public boolean heroAction(GameInfo gameInfo, CharacterImpl player, String message) {
		boolean isSuccess = false;

		// 영웅 일반 공격

		return isSuccess;
	}

	public int getVitality() {
		return vitality;
	}

	public void setVitality(int vitality) {
		this.vitality = vitality;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public String getFirstGreeting() {
		return firstGreeting;
	}

	public void setFirstGreeting(String firstGreeting) {
		this.firstGreeting = firstGreeting;
	}

	public Enum<CharacterJob> getJob() {
		return job;
	}

	public void setJob(Enum<CharacterJob> job) {
		this.job = job;
	}

	public Enum<CharacterState> getState() {
		return state;
	}

	public void setState(Enum<CharacterState> state) {
		this.state = state;
	}

	public EnumSet<Secret> getSecret() {
		return secret;
	}

	public void setSecret(EnumSet<Secret> secret) {
		this.secret = secret;
	}
	
}
