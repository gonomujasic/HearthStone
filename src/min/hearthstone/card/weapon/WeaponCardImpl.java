package min.hearthstone.card.weapon;

import min.hearthstone.card.CardImpl;

public abstract class WeaponCardImpl extends CardImpl implements WeaponCard{

	private int attack;
	private int durability;
	
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDurability() {
		return durability;
	}
	public void setDurability(int durability) {
		this.durability = durability;
	}
	
	
	
}
