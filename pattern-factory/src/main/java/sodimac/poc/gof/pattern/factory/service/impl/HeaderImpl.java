package sodimac.poc.gof.pattern.factory.service.impl;

import sodimac.poc.gof.pattern.factory.dto.NSREvent;
import sodimac.poc.gof.pattern.factory.service.EventMessage;

public class HeaderImpl extends EventMessage {

	public Boolean validateEvent(NSREvent event) {
		System.out.println("\nSe ejecuto el impl para un evento Header");
		return true;
	}

	public String setDataEvent(NSREvent event) {
		System.out.println("Se construyo el atributo data para un mensaje Header");
		return "DataHeader";
	}
}
