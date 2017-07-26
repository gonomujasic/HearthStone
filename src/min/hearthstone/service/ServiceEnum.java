package min.hearthstone.service;

public enum ServiceEnum {
	// ! 턴 넘김, @ 영웅 일반 공격, # 영웅 특수 능력, $ 스펠, % 무기, ^ 하수인 일반 공격, & 하수인 특수 능력,  
	BASIC_SETTING("~"), TERN_OVER("!"), HERO_ATTACK("@"), HERO_SPECIAL_ABILITY("#"), PLAY_SPELL_CARD("$"), 
	PLAY_WEAPON_CARD("%"), PLAY_MINION_CARD("^"),MINION_ATTACK("&"), MINION_SPECIAL_ABILITY("*"), DRAW_CARD("-");
	
	private final String name;
	
	private ServiceEnum(String name) {
		this.name= name;
	}
	
	public String getName(){
		return name;
	}
	
	public static ServiceEnum getConstance(String name){
		
		for(ServiceEnum ce:ServiceEnum.values()){
			
			if(ce.getName().equalsIgnoreCase(name)){
				return ce;
			}
		}
		return null;
	}
	
}
