package min.hearthstone.card.spell;

public enum SpellCardEnum {

	S_MIRROR_IMAGE("S_Mirror_Image");
	
	final private String name;
	
	private SpellCardEnum(String name){
		
		this.name = name;
		
	}
	
	public String getName(){
		return name;
	
	}
	
	public static SpellCardEnum getConstance(String name){
		
		for(SpellCardEnum ce:SpellCardEnum.values()){
			
			if(ce.getName().equalsIgnoreCase(name)){
				return ce;
			}
		}
		return null;
	}
}
