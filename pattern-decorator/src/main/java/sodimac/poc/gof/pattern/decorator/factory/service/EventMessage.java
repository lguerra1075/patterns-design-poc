package sodimac.poc.gof.pattern.decorator.factory.service;

import sodimac.poc.gof.pattern.decorator.factory.dto.Event;
import sodimac.poc.gof.pattern.decorator.factory.dto.NSREvent;

public abstract class EventMessage {
	
	public abstract Boolean validateEvent(NSREvent event);
	
	public abstract String setDataEvent(NSREvent event);
	
	public Event createEvent(NSREvent nsrEvent, String data){
				
		System.out.println("El metodo CREATE EVENT es comun para ambos casos");
		
		Event event = new Event();		
		event.setId(nsrEvent.getId());
		event.setRsvLevel(nsrEvent.getRsvLevel());
		event.setCountry(nsrEvent.getCountry());
		event.setData(data);
		
		return event;
		
	}
}
