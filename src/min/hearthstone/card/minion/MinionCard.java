package min.hearthstone.card.minion;

import min.hearthstone.game.GameInfo;

public interface MinionCard {

	void minionSpecialAction(GameInfo gameInfo, String message);
}
