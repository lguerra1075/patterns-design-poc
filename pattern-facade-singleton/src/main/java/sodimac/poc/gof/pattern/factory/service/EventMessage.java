package sodimac.poc.gof.pattern.factory.service;

import sodimac.poc.gof.pattern.factory.dto.Event;
import sodimac.poc.gof.pattern.factory.dto.NSREvent;

public interface EventMessage {
	
	public Boolean validateEvent(NSREvent event);
	
	public String setDataEvent(NSREvent event);
	
	public Event createEvent(NSREvent nsrEvent, String data);
}
