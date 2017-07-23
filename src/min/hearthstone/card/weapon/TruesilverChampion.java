package min.hearthstone.card.weapon;

import min.hearthstone.card.CardClass;
import min.hearthstone.card.CardJob;
import min.hearthstone.card.CardPackage;
import min.hearthstone.card.CardState;
import min.hearthstone.game.GameInfo;

public class TruesilverChampion extends WeaponCardImpl {

	public TruesilverChampion() {
		
		this.setAttack(4);
		this.setDurability(2);
		this.setCardClass(CardClass.FREE);
		this.setCardJob(CardJob.PALADIN);
		this.setCardPackage(CardPackage.ORIGINAL);
		this.setCardState(CardState.PUBLISHED);
		this.setDescription("Whenever your hero attacks, restore 2 Health to it");
		this.setTier(4);
		
		
	}
	
	@Override
	public void action(GameInfo gameInfo, String massage) {
		
		
	}

	
	
}
