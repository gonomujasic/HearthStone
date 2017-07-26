package min.hearthstone.card.spell;

import min.hearthstone.card.CardClass;
import min.hearthstone.card.CardJob;
import min.hearthstone.card.CardPackage;
import min.hearthstone.card.CardState;
import min.hearthstone.game.GameInfo;

public class Frostbolt extends SpellCardImpl {

	public Frostbolt() {
		this.setCardClass(CardClass.FREE);
		this.setCardJob(CardJob.MAGE);
		this.setCardPackage(CardPackage.ORIGINAL);
		this.setCardState(CardState.PUBLISHED);
		this.setDescription("Deal 3 damage to a character and Freeze it.");
		this.setTarget(true);
		this.setTier(2);
	}
	
	@Override
	public void execute(GameInfo gameInfo, String Speller, String target) {
		// TODO Auto-generated method stub

	}

}
