package sodimac.poc.gof.pattern.factory.service.impl;

import sodimac.poc.gof.pattern.factory.dto.Event;
import sodimac.poc.gof.pattern.factory.dto.NSREvent;
import sodimac.poc.gof.pattern.factory.service.EventMessage;

public class DetailImpl implements EventMessage{
	
	public Boolean validateEvent(NSREvent event) {
		System.out.println("\nSe ejecuto el impl para un evento Detail");
		return true;
	}

	public String setDataEvent(NSREvent event) {
		System.out.println("Se construyo el atributo data para un mensaje Detail");
		return "DataDetail";
	}

	public Event createEvent(NSREvent nsrEvent, String data) {
		System.out.println("Se creo el evento para un mensaje Detail");
		
		Event event = new Event();		
		event.setId(nsrEvent.getId());
		event.setRsvLevel(nsrEvent.getRsvLevel());
		event.setCountry(nsrEvent.getCountry());
		event.setData(data);
		
		return event;		
	}
}
