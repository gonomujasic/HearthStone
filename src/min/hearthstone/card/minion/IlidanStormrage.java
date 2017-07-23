package min.hearthstone.card.minion;

import java.util.EnumSet;
import java.util.Set;

import min.hearthstone.card.CardClass;
import min.hearthstone.card.CardJob;
import min.hearthstone.card.CardPackage;
import min.hearthstone.card.CardState;
import min.hearthstone.card.Species;
import min.hearthstone.character.CharacterImpl;
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
		Set<MinionState> minionStateSet = EnumSet.of(MinionState.NORMAL);
		this.setMinionStates(minionStateSet);
		this.setCardState(CardState.PUBLISHED);
		this.setCardJob(CardJob.NEUTRAL);
		
	}
	
	@Override
	public void minionAction(GameInfo gameInfo, CharacterImpl player, String message) {
		
		
	}

	@Override
	public void minionSpecialAction(GameInfo gameInfo, CharacterImpl player, String message) {
		
		if (gameInfo.getCardOwnedByPO().equals(player)) {
			
			gameInfo.getPOSideMinion().add(new FlameOfAzzinoth());
			
		} else {
			gameInfo.getPTSideMinion().add(new FlameOfAzzinoth());
		}
	}
}
