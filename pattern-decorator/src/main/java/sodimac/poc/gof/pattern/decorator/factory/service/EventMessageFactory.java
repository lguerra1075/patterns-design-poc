package sodimac.poc.gof.pattern.decorator.factory.service;

import sodimac.poc.gof.pattern.decorator.factory.enumeration.RsvLevelEnum;
import sodimac.poc.gof.pattern.decorator.factory.service.impl.DetailImpl;
import sodimac.poc.gof.pattern.decorator.factory.service.impl.HeaderImpl;
import sodimac.poc.gof.pattern.decorator.factory.service.impl.SaveDataBaseDecoratorImpl;

public class EventMessageFactory {

	public EventMessage getEventMessage(String rsvLevel, String flagDB) {
		EventMessage eventMessage = null;
		try {
			RsvLevelEnum rsvLevelEnum = RsvLevelEnum.valueOf(rsvLevel);
			switch (rsvLevelEnum) {
			case HDR:
				if(flagDB.equalsIgnoreCase("S")) {
					eventMessage = new SaveDataBaseDecoratorImpl(new HeaderImpl());
				}else {
					eventMessage = new HeaderImpl();
				}
				break;
			case DTL:
				if(flagDB.equalsIgnoreCase("S")) {
					eventMessage = new SaveDataBaseDecoratorImpl(new DetailImpl());
				}else {
					eventMessage = new DetailImpl();
				}				
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
