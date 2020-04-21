package sodimac.poc.gof.pattern.strategy.enumeration;

public enum RsvLevelEnum {
	HDR("HDR"), DTL("DTL");
	
	private String rsvLevel;
	
	RsvLevelEnum(String rsvLevel){
		this.rsvLevel = rsvLevel;
	}
	
	public String getRsvLevel() {
		return this.rsvLevel;
	}
}
