package min.hearthstone.card.spell;

import min.hearthstone.game.GameInfo;

public interface SpellCard {

	void execute(GameInfo gameInfo, String Speller, String target);
}
