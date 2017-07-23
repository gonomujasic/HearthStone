package min.hearthstone.card.spell;

import min.hearthstone.card.CardClass;
import min.hearthstone.card.CardJob;
import min.hearthstone.card.CardPackage;
import min.hearthstone.card.CardState;
import min.hearthstone.game.GameInfo;

public class MirrorImage extends SpellCardImpl{

	public MirrorImage() {
		
		this.setTier(1);
		this.setCardPackage(CardPackage.ORIGINAL);
		this.setCardState(CardState.PUBLISHED);
		this.setCardClass(CardClass.FREE);
		this.setDescription("Summon two 0/2 minions with Taunt");
		this.setCardJob(CardJob.MAGE);
	}
	
	@Override
	public void execute(GameInfo gameInfo, String speller, String target) {
		
		
		
	}

}
