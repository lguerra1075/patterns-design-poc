package sodimac.poc.gof.pattern.factory.service;

import sodimac.poc.gof.pattern.factory.enumeration.RsvLevelEnum;
import sodimac.poc.gof.pattern.factory.service.impl.DetailImpl;
import sodimac.poc.gof.pattern.factory.service.impl.HeaderImpl;

public class EventMessageFactory {

	public EventMessage getEventMessage(String rsvLevel) {
		EventMessage eventMessage = null;
		try {
			RsvLevelEnum rsvLevelEnum = RsvLevelEnum.valueOf(rsvLevel);
			switch (rsvLevelEnum) {
			case HDR:
				eventMessage = new HeaderImpl();
				break;
			case DTL:
				eventMessage = new DetailImpl();
				break;
			default:
				break;
			}
		} catch (IllegalArgumentException e) {
			System.out.println("El valor ingresado es incorrecto\n");
		}
		return eventMessage;
	}
}
