package sodimac.poc.gof.pattern.chain.responsability.dto;

import lombok.Data;

@Data
public class Payment {
	
	private String id;
	private Integer status;
	private String country;	
	private String data;
}
