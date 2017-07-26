package min.hearthstone.card.minion;

import java.util.EnumSet;
import java.util.Set;

import min.hearthstone.card.CardClass;
import min.hearthstone.card.CardJob;
import min.hearthstone.card.CardPackage;
import min.hearthstone.card.CardState;
import min.hearthstone.card.Species;
import min.hearthstone.game.GameInfo;

public class IlidanStormrage extends MinionCardImpl {

	public IlidanStormrage() {
		
		this.setAttack(7);
		this.setHealth(5);
		this.setCardClass(CardClass.LEGEND);
		this.setCardPackage(CardPackage.ORIGINAL);
		this.setDescription("Whenever you play a card, summon a 2/1 Flame of Azzinoth");
		this.setTier(7);
		this.setSpecies(Species.DEMON);
		Set<MinionStateNAbility> minionStateSet = EnumSet.of(MinionStateNAbility.NORMAL);
		this.setMinionStates(minionStateSet);
		this.setCardState(CardState.PUBLISHED);
		this.setCardJob(CardJob.NEUTRAL);
		
	}
	
	@Override
	public void minionSpecialAction(GameInfo gameInfo, String message) {
		
		String str = message.substring(1, 2);
		
		if (str.equals("mo")) {
			
			gameInfo.getPOSideMinion().add(new FlameOfAzzinoth());
			
		} else {
			gameInfo.getPTSideMinion().add(new FlameOfAzzinoth());
		}
	}
}
