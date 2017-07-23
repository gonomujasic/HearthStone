package min.hearthstone.card.minion;

import java.util.Set;

import min.hearthstone.card.CardImpl;
import min.hearthstone.card.Species;
import min.hearthstone.character.CharacterImpl;
import min.hearthstone.game.GameInfo;

public abstract class MinionCardImpl extends CardImpl implements MinionCard{

	private int attack;
	private int health;
	private Enum<Species> species;
	private Set<MinionState> states;
	
	void minionAction(GameInfo gameInfo, CharacterImpl player, String message) {
		
		
		
	}
	
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public Enum<Species> getSpecies() {
		return species;
	}
	public void setSpecies(Enum<Species> species) {
		this.species = species;
	}
	public Set<MinionState> getMinionStates() {
		return states;
	}
	public void setMinionStates(Set<MinionState> states) {
		this.states = states;
	}
	

	
}
