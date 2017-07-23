package min.hearthstone.card.minion;

public enum MinionCardEnum {

	M_ILIDAN_STORMRAGE("M_Ilidan_Stormrage"), 
	M_FLAME_OF_AZZINOTH("M_Flame_Of_Azzinoth"), 
	M_MIRROR_IMAGE("M_Mirror_Image");
	
	final private String name;
	
	private MinionCardEnum(String name){
		this.name= name;
	}
	
	public String getName(){
		return name;
	}
	
	public static MinionCardEnum getConstance(String name){
		
		for(MinionCardEnum ce:MinionCardEnum.values()){
			
			if(ce.getName().equalsIgnoreCase(name)){
				return ce;
			}
		}
		return null;
	}
}
