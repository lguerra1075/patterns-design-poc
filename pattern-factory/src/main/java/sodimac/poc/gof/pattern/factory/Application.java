package sodimac.poc.gof.pattern.factory;

import java.util.Scanner;

import com.google.gson.Gson;

import sodimac.poc.gof.pattern.factory.dto.Event;
import sodimac.poc.gof.pattern.factory.dto.NSREvent;
import sodimac.poc.gof.pattern.factory.service.EventMessage;
import sodimac.poc.gof.pattern.factory.service.EventMessageFactory;

public class Application {

	public static void main(String[] args) {
		String rsvLevel = "";
		do {
			System.out.println("-------- >>>>> Patron Factory <<<<< --------: ");
			System.out.print("Ingrese el rsvLevel: ");
			Scanner entrada = new Scanner(System.in);
			rsvLevel = entrada.nextLine();

			if (!rsvLevel.equalsIgnoreCase("E")) {
				NSREvent nsrEventHdr = new NSREvent();

				nsrEventHdr.setId("a146356-454-334-6853-7567-2379674");
				nsrEventHdr.setCountry("CL");
				nsrEventHdr.setRsvLevel(rsvLevel);
				nsrEventHdr.setData("");

				EventMessageFactory factory = new EventMessageFactory();
				EventMessage eventMessage = factory.getEventMessage(nsrEventHdr.getRsvLevel());

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
