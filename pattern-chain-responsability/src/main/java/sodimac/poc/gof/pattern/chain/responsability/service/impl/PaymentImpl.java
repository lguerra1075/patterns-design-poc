package sodimac.poc.gof.pattern.chain.responsability.service.impl;

import com.google.gson.Gson;

import sodimac.poc.gof.pattern.chain.responsability.dto.Event;
import sodimac.poc.gof.pattern.chain.responsability.dto.Payment;
import sodimac.poc.gof.pattern.chain.responsability.service.AbstractProcess;

public class PaymentImpl extends AbstractProcess {

	public PaymentImpl(int level) {
		this.level = level;
	}

	@Override
	protected void createNewEvent(Event event) {
		
		System.out.println("Mensaje de Payment");
		Payment payment = new Payment();
		payment.setId(event.getId());
		payment.setStatus(event.getStatus());
		payment.setCountry("CL");
		payment.setData("Se creo un evento con la estructura Payment");
		
		Gson gson = new Gson();		
		System.out.println("Estructura Payment: "+ gson.toJson(payment) + "\n");
	
	}
}
