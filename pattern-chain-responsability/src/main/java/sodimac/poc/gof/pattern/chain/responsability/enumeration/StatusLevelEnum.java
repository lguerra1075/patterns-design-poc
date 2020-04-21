package sodimac.poc.gof.pattern.chain.responsability.enumeration;

public enum StatusLevelEnum {
	PAYMENT(1, new Integer[]{1, 3}), 
	SHIPMENT_LINE(2, new Integer[]{4, 5, 6}), 
	FULFILLMENT(3, new Integer[]{2, 7});
	
	private Integer level;
	private Integer[] groupStatus;
	
	StatusLevelEnum(Integer level, Integer[] groupStatus){
		this.level = level;
		this.groupStatus = groupStatus;
	}
	
	public Integer getLevel() {
		return this.level;
	}
	
	public Integer[] getGroupStatus() {
		return this.groupStatus;
	}
}
