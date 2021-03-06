package min.hearthstone.card.minion;

import java.util.EnumSet;
import java.util.Set;

import min.hearthstone.card.CardClass;
import min.hearthstone.card.CardJob;
import min.hearthstone.card.CardPackage;
import min.hearthstone.card.CardState;
import min.hearthstone.card.Species;
import min.hearthstone.game.GameInfo;

public class FlameOfAzzinoth extends MinionCardImpl {

	public FlameOfAzzinoth() {
		
		this.setAttack(2);
		this.setHealth(1);
		this.setCardClass(CardClass.NORMAL);
		this.setCardPackage(CardPackage.ORIGINAL);
		this.setDescription("");
		this.setTier(0);
		this.setSpecies(Species.ELEMENTS);
		Set<MinionStateNAbility> minionStateSet = EnumSet.of(MinionStateNAbility.NORMAL) ;
		this.setMinionStates(minionStateSet);
		this.setCardState(CardState.OPERATIONAL);
		this.setCardJob(CardJob.NEUTRAL);
	}
	
	@Override
	public void minionSpecialAction(GameInfo gameInfo, String message) {
		// TODO Auto-generated method stub
		
	}

}
