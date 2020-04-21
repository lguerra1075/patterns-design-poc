package sodimac.poc.gof.pattern.strategy.service.impl;

import sodimac.poc.gof.pattern.strategy.dto.ErrorNSR;
import sodimac.poc.gof.pattern.strategy.dto.NSREvent;
import sodimac.poc.gof.pattern.strategy.service.DataBaseStrategy;

public class FirestoreDataBase implements DataBaseStrategy{

	public Boolean saveData(NSREvent event) {
		System.out.println("Se guarda la data en la BD Firestore");
		return null;
	}

	public Boolean saveError(ErrorNSR error) {
		System.out.println("Se guarda el error en la BD Firestore\n");
		return null;
	}

	public NSREvent getDataEvent(String orderNumber) {
		System.out.println("Obtenemos la data de la BD Firestore");
		return null;
	}
	
	
}
