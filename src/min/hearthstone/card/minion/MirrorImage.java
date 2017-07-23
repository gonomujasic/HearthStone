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

public class MirrorImage extends MinionCardImpl{

	public MirrorImage() {
		
		this.setAttack(0);
		this.setCardClass(CardClass.FREE);
		this.setCardJob(CardJob.MAGE);
		this.setCardPackage(CardPackage.ORIGINAL);
		this.setCardState(CardState.OPERATIONAL);
		this.setDescription("Taunt");
		this.setHealth(2);
		Set<MinionState> minionStateSet = EnumSet.of(MinionState.TAUNT);
		this.setMinionStates(minionStateSet);
		this.setSpecies(Species.NONE);
		this.setTier(0);
		
	}
	
	@Override
	public void minionAction(GameInfo gameInfo, CharacterImpl player, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void minionSpecialAction(GameInfo gameInfo, CharacterImpl player, String message) {
		// TODO Auto-generated method stub
		
	}

}
