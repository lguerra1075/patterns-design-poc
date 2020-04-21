package sodimac.poc.gof.pattern.chain.responsability.dto;

import lombok.Data;

@Data
public class ShipmentLine {
	
	private String id;
	private Integer status;
	private String mensaje;
	private String sku;
}
