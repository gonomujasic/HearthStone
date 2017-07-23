package min.hearthstone.card.minion;

import min.hearthstone.character.CharacterImpl;
import min.hearthstone.game.GameInfo;

public interface MinionCard {

	void minionSpecialAction(GameInfo gameInfo, CharacterImpl player, String message);
}
