package min.hearthstone.card.minion;

import java.util.Set;

import min.hearthstone.card.CardImpl;
import min.hearthstone.card.Species;

public abstract class MinionCardImpl extends CardImpl implements MinionCard{

	private int attack;
	private int health;
	private Enum<Species> species;
	private Set<MinionStateNAbility> states;
	
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
	public Set<MinionStateNAbility> getMinionStates() {
		return states;
	}
	public void setMinionStates(Set<MinionStateNAbility> states) {
		this.states = states;
	}
	

	
}
