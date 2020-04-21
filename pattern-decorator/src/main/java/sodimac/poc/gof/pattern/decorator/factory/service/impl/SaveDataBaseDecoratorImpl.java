package sodimac.poc.gof.pattern.decorator.factory.service.impl;

import com.google.gson.Gson;

import sodimac.poc.gof.pattern.decorator.factory.dto.NSREvent;
import sodimac.poc.gof.pattern.decorator.factory.service.EventMessage;

public class SaveDataBaseDecoratorImpl extends EventMessage {
	
	protected EventMessage eventMessage;

	public SaveDataBaseDecoratorImpl(EventMessage eventMessage) {
		this.eventMessage = eventMessage;
	}

	@Override
	public Boolean validateEvent(NSREvent event) {		
		saveDataBase(event);
		return eventMessage.validateEvent(event);
	}

	@Override
	public String setDataEvent(NSREvent event) {
		return eventMessage.setDataEvent(event);		
	}

	private void saveDataBase(NSREvent event) {
		System.out.println("\nSe agrego la funcionalidad de insertar a la BASE DE DATOS");
		Gson gson = new Gson();
		System.out.println("Se insertara: ----->>>" + gson.toJson(event)+"\n");
	}
}
