package sodimac.poc.gof.pattern.decorator.factory;

import java.util.Scanner;

import com.google.gson.Gson;

import sodimac.poc.gof.pattern.decorator.factory.dto.Event;
import sodimac.poc.gof.pattern.decorator.factory.dto.NSREvent;
import sodimac.poc.gof.pattern.decorator.factory.service.EventMessage;
import sodimac.poc.gof.pattern.decorator.factory.service.EventMessageFactory;

public class Application {

	public static void main(String[] args) {
		String rsvLevel = "";
		String flagDB = "";
		do {
			System.out.println("-------- >>>>> Patron Decorator <<<<< --------: ");
			System.out.print("Ingrese el rsvLevel: ");
			Scanner entrada = new Scanner(System.in);
			rsvLevel = entrada.nextLine();

			if (!rsvLevel.equalsIgnoreCase("E")) {
				NSREvent nsrEventHdr = new NSREvent();

				nsrEventHdr.setId("b2379674-334-6853-454-7567-146356");
				nsrEventHdr.setCountry("CL");
				nsrEventHdr.setRsvLevel(rsvLevel);
				nsrEventHdr.setData("");

				System.out.print("Desea ingresar en Base de Datos Si(S) - No(N)???: ");
				entrada = new Scanner(System.in);
				flagDB = entrada.nextLine();

				EventMessageFactory factory = new EventMessageFactory();
				EventMessage eventMessage = factory.getEventMessage(nsrEventHdr.getRsvLevel(), flagDB);

				if (null != eventMessage) {
					eventMessage.validateEvent(nsrEventHdr);
					Event event = eventMessage.createEvent(nsrEventHdr, eventMessage.setDataEvent(nsrEventHdr));

					Gson gson = new Gson();
					System.out.println("--->> Event OO:" + gson.toJson(event) + "\n");
				}

			}
		} while (!rsvLevel.equalsIgnoreCase("E"));

	}

}
