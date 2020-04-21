package sodimac.poc.gof.pattern.strategy;

import java.util.Scanner;

import sodimac.poc.gof.pattern.strategy.dto.ErrorNSR;
import sodimac.poc.gof.pattern.strategy.dto.NSREvent;
import sodimac.poc.gof.pattern.strategy.service.Context;
import sodimac.poc.gof.pattern.strategy.service.DataBaseStrategy;
import sodimac.poc.gof.pattern.strategy.service.impl.FirestoreDataBase;
import sodimac.poc.gof.pattern.strategy.service.impl.MongoDB;

public class Application {
		
	public static void main(String[] args) {
		
		String rsvLevel = "";
		do {
			System.out.println("----->>>>> Patron Estrategia <<<<<----- ");
			System.out.print("Ingrese el la base de datos firestore(F) - MongoDB(M), Exit(E): ");
			Scanner entrada = new Scanner(System.in);
			rsvLevel = entrada.nextLine();
			
			if (!rsvLevel.equalsIgnoreCase("E")) {				
				NSREvent nsrEventHdr = new NSREvent();

				nsrEventHdr.setId("a146356-454-334-6853-7567-2379674");
				nsrEventHdr.setCountry("CL");
				nsrEventHdr.setRsvLevel(rsvLevel);
				nsrEventHdr.setData("");
				
				//Esta logica pudiera estar desde properties
				DataBaseStrategy strategy = null;
				if(rsvLevel.equalsIgnoreCase("F")) {
					strategy = new FirestoreDataBase();
				}else {
					strategy = new MongoDB();
				}
				
				Context context = new Context(strategy);
		        context.saveDataStrategy(nsrEventHdr);
				context.getDataStrategy(nsrEventHdr);
				context.saveErrorStrategy(new ErrorNSR());
			}
			
		} while (!rsvLevel.equalsIgnoreCase("E"));

	}
	
}
