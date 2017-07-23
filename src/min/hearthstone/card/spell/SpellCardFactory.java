package min.hearthstone.card.spell;

import java.util.EnumMap;

public class SpellCardFactory {

	private static class SpellCardSingleton{
		
		private static EnumMap<SpellCardEnum,SpellCard> spellCard = new EnumMap<SpellCardEnum, SpellCard>(SpellCardEnum.class); 
		
	}
	
	public static EnumMap<SpellCardEnum,SpellCard> getSpellMap(){
		return SpellCardSingleton.spellCard;
	}
	
	private void loadSpellCard(){
		
		EnumMap<SpellCardEnum,SpellCard> spellCard = getSpellMap();
		
		if(spellCard.isEmpty()){
			getSpellMap().put(SpellCardEnum.S_MIRROR_IMAGE, new MirrorImage());
		
		}
	}
	
	public SpellCard getSpellCard(SpellCardEnum spellCardENum){
		
		loadSpellCard();
		SpellCard spellCard = null;
		if(!getSpellMap().get(spellCardENum).equals(null))
		spellCard = getSpellMap().get(spellCardENum);
		
		return spellCard;
		 
	}
}
