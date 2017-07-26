package min.hearthstone.card.spell;

import java.util.EnumMap;

public class SpellCardFactory {

	private static class SpellCardSingleton{
		
		private static final EnumMap<SpellCardEnum,SpellCard> SPELLCARD = new EnumMap<SpellCardEnum, SpellCard>(SpellCardEnum.class); 
		
	}
	
	public static EnumMap<SpellCardEnum,SpellCard> getSpellMap(){
		return SpellCardSingleton.SPELLCARD;
	}
	
	private void loadSpellCard(){
		
		EnumMap<SpellCardEnum,SpellCard> spellCard = getSpellMap();
		
		if(spellCard.isEmpty()){
			getSpellMap().put(SpellCardEnum.S_MIRROR_IMAGE, new MirrorImage());
			getSpellMap().put(SpellCardEnum.S_COIN, new Coin());
			getSpellMap().put(SpellCardEnum.S_ARCANE_EXPLOSION, new ArcaneExplosion());
			getSpellMap().put(SpellCardEnum.S_FROSTBOLT, new Frostbolt());
		
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
