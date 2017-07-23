package min.hearthstone.character;

import javax.websocket.Session;

import min.hearthstone.game.GameInfo;

public abstract class CharacterImpl implements Character{

	private int vitality;
	private String heroName;
	private String firstGreeting;
	private Enum<CharacterJob> job;
	private Enum<CharacterState> state;
	

	public boolean heroAction(GameInfo gameInfo, CharacterImpl player, String message) {
		boolean isSuccess = false;
		
		//영웅 일반 공격
		
		return isSuccess;
	}
	
	
	public int getVitality() {
		return vitality;
	}
	public void setVitality(int vitality) {
		this.vitality = vitality;
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
	
}
