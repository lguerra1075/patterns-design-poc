package sodimac.poc.gof.pattern.factory.service;

import sodimac.poc.gof.pattern.factory.dto.Event;
import sodimac.poc.gof.pattern.factory.dto.NSREvent;
import sodimac.poc.gof.pattern.factory.enumeration.RsvLevelEnum;
import sodimac.poc.gof.pattern.factory.service.impl.DetailImpl;
import sodimac.poc.gof.pattern.factory.service.impl.HeaderImpl;

public class EventMessageInvoker {
	
	private EventMessage eventMessage;

	public Event processEventMessage(NSREvent nsrEventHdr) {
		Event event = null;
		try {
			RsvLevelEnum rsvLevelEnum = RsvLevelEnum.valueOf(nsrEventHdr.getRsvLevel());
			switch (rsvLevelEnum) {
			case HDR:
				eventMessage = new HeaderImpl();
				eventMessage.validateEvent(nsrEventHdr);				
				event = eventMessage.createEvent(nsrEventHdr, eventMessage.setDataEvent(nsrEventHdr));
				break;
			case DTL:
				eventMessage = new DetailImpl();
				eventMessage.validateEvent(nsrEventHdr);				
				event = eventMessage.createEvent(nsrEventHdr, eventMessage.setDataEvent(nsrEventHdr));
				break;
			default:
				break;
			}
		} catch (IllegalArgumentException e) {
			System.out.println("El valor ingresado es incorrecto\n");
		}
		return event;
	}
}
