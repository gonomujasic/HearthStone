package min.hearthstone.card.spell;

import min.hearthstone.card.CardClass;
import min.hearthstone.card.CardJob;
import min.hearthstone.card.CardPackage;
import min.hearthstone.card.CardState;
import min.hearthstone.game.GameInfo;

public class Coin extends SpellCardImpl{

	public Coin() {
		
		setCardClass(CardClass.FREE);
		setCardJob(CardJob.NEUTRAL);
		setCardPackage(CardPackage.ORIGINAL);
		setCardState(CardState.OPERATIONAL);
		setDescription("Game 1 Mana Crystal this turn only");
		setTier(0);
		setTarget(false);
		
	}
	
	@Override
	public void execute(GameInfo gameInfo, String Speller, String target) {
		// TODO Auto-generated method stub
		
	}

}
