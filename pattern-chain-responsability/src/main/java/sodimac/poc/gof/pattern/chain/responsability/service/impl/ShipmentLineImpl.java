package sodimac.poc.gof.pattern.chain.responsability.service.impl;

import com.google.gson.Gson;

import sodimac.poc.gof.pattern.chain.responsability.dto.Event;
import sodimac.poc.gof.pattern.chain.responsability.dto.ShipmentLine;
import sodimac.poc.gof.pattern.chain.responsability.service.AbstractProcess;

public class ShipmentLineImpl extends AbstractProcess {

	public ShipmentLineImpl(int level) {
		this.level = level;
	}

	@Override
	protected void createNewEvent(Event event) {
		
		ShipmentLine shipmentLine = new ShipmentLine();
		shipmentLine.setId(event.getId());
		shipmentLine.setStatus(event.getStatus());
		shipmentLine.setSku(event.getSku());
		shipmentLine.setMensaje("Se creo un evento con la estructura ShipmentLine");
		
		System.out.println("Mensaje de ShipmentLine");
		Gson gson = new Gson();		
		System.out.println("Estructura ShipmentLine: "+ gson.toJson(shipmentLine) + "\n");
	}
}
