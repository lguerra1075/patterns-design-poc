package sodimac.poc.gof.pattern.chain.responsability.service.impl;

import com.google.gson.Gson;

import sodimac.poc.gof.pattern.chain.responsability.dto.Event;
import sodimac.poc.gof.pattern.chain.responsability.dto.Fulfillment;
import sodimac.poc.gof.pattern.chain.responsability.service.AbstractProcess;

public class FulfillmentImpl extends AbstractProcess {
	
	public FulfillmentImpl(int level) {
		this.level = level;
	}

	@Override
	protected void createNewEvent(Event event) {
		
		System.out.println("Mensaje de Fulfillment");
		Fulfillment fulfillment = new Fulfillment();
		fulfillment.setId(event.getId());
		fulfillment.setStatus(event.getStatus());
		fulfillment.setMensaje("Se creo un evento con la estructura Fulfillment \n");
		
		Gson gson = new Gson();		
		System.out.println("Estructura Fulfilment: "+ gson.toJson(fulfillment) + "\n");
		
	}
}
