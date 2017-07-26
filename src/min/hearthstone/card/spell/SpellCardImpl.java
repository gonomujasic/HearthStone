package min.hearthstone.card.spell;

import min.hearthstone.card.CardImpl;
import min.hearthstone.character.CharacterImpl;
import min.hearthstone.game.GameInfo;

public abstract class SpellCardImpl extends CardImpl implements SpellCard{

	private boolean isTarget;

	public boolean isTarget() {
		return isTarget;
	}

	public void setTarget(boolean isTarget) {
		this.isTarget = isTarget;
	}
	
	
}
