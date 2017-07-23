package min.hearthstone.card.weapon;

import java.util.EnumMap;

public class WeaponCardFactory {

	private static class WeaponCardSingleton{
		
		private static EnumMap<WeaponCardEnum, WeaponCard> enumMap = new EnumMap<WeaponCardEnum, WeaponCard>(WeaponCardEnum.class);
		
	}
	
	public static EnumMap<WeaponCardEnum, WeaponCard> getWeaponCardMap(){
		return WeaponCardSingleton.enumMap;
	}
	
	private void loadWeaponCard(){
		
		EnumMap<WeaponCardEnum, WeaponCard> enumMap = getWeaponCardMap();
		
		if(enumMap.isEmpty()){
			//생성자 호출 자동 생성 없나.. 포문에서 돌리면 한방인데.. 
			enumMap.put(WeaponCardEnum.W_TRUESILVER_CHAMPION, new TruesilverChampion());
			
		}
		
	}
	
	public WeaponCard getWeaponCard(){

		loadWeaponCard();
		
		return getWeaponCard();
	}
	
}
