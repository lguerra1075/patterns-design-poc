package sodimac.poc.gof.pattern.factory.service;

import sodimac.poc.gof.pattern.factory.dto.Event;
import sodimac.poc.gof.pattern.factory.dto.NSREvent;
import sodimac.poc.gof.pattern.factory.enumeration.RsvLevelEnum;
import sodimac.poc.gof.pattern.factory.service.impl.DetailImpl;
import sodimac.poc.gof.pattern.factory.service.impl.HeaderImpl;

public class EventMessageMaker {

	private EventMessage header;
	private EventMessage detail;

	private static EventMessageMaker eventMessageMaker;

	private EventMessageMaker() {
		header = new HeaderImpl();
		detail = new DetailImpl();
	}

	public static EventMessageMaker getEventMessageMaker() {
		if (null == eventMessageMaker) {
			System.out.println("############ Se creo el objeto fachada ############");
			eventMessageMaker = new EventMessageMaker();
		}
		return eventMessageMaker;
	}

	public Event processEvent(NSREvent nsrEventHdr) {

		Event event = null;
		try {
			RsvLevelEnum rsvLevelEnum = RsvLevelEnum.valueOf(nsrEventHdr.getRsvLevel());
			switch (rsvLevelEnum) {
			case HDR:
				this.header.validateEvent(nsrEventHdr);
				event = this.header.createEvent(nsrEventHdr, this.header.setDataEvent(nsrEventHdr));
				break;
			case DTL:
				this.detail.validateEvent(nsrEventHdr);
				event = this.detail.createEvent(nsrEventHdr, detail.setDataEvent(nsrEventHdr));
				break;
			default:
				break;
			}
		} catch (IllegalArgumentException e) {
			System.out.println("El valor ingresado es incorrecto\n");
		}

		return event;
	}

	public EventMessage getHeader() {
		return header;
	}

	public void setHeader(EventMessage header) {
		this.header = header;
	}

	public EventMessage getDetail() {
		return detail;
	}

	public void setDetail(EventMessage detail) {
		this.detail = detail;
	}

}
