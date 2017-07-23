package min.hearthstone.card.weapon;

public enum WeaponCardEnum {

	W_TRUESILVER_CHAMPION("W_Truesilver_Champion");
	
	private final String name; 
	
	private WeaponCardEnum(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	
	}
	
	public static WeaponCardEnum getConstance(String name){
		
		for(WeaponCardEnum ce:WeaponCardEnum.values()){
			
			if(ce.getName().equalsIgnoreCase(name)){
				return ce;
			}
		}
		return null;
	}
	
}
