package min.hearthstone.card.spell;

import min.hearthstone.card.CardClass;
import min.hearthstone.card.CardJob;
import min.hearthstone.card.CardPackage;
import min.hearthstone.card.CardState;
import min.hearthstone.game.GameInfo;

public class ArcaneExplosion extends SpellCardImpl {

	public ArcaneExplosion() {
		
		this.setCardClass(CardClass.FREE);
		this.setCardJob(CardJob.MAGE);
		this.setCardPackage(CardPackage.ORIGINAL);
		this.setCardState(CardState.PUBLISHED);
		this.setDescription("Deal 1 damage to all enemy minions.");
		this.setTier(2);
		this.setTarget(false);
	}
	
	@Override
	public void execute(GameInfo gameInfo, String Speller, String target) {

		
		
	}

}
