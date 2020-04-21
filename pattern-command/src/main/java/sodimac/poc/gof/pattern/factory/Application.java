package sodimac.poc.gof.pattern.factory;

import java.util.Scanner;

import com.google.gson.Gson;

import sodimac.poc.gof.pattern.factory.dto.Event;
import sodimac.poc.gof.pattern.factory.dto.NSREvent;
import sodimac.poc.gof.pattern.factory.service.EventMessage;
import sodimac.poc.gof.pattern.factory.service.EventMessageInvoker;

public class Application {

	public static void main(String[] args) {
		String rsvLevel = "";
		do {
			System.out.println("-------- >>>>> Patron Command <<<<< --------: ");
			System.out.print("Ingrese el rsvLevel: ");
			Scanner entrada = new Scanner(System.in);
			rsvLevel = entrada.nextLine();

			if (!rsvLevel.equalsIgnoreCase("E")) {
				NSREvent nsrEventHdr = new NSREvent();

				nsrEventHdr.setId("a146356-454-334-6853-7567-2379674");
				nsrEventHdr.setCountry("CL");
				nsrEventHdr.setRsvLevel(rsvLevel);
				nsrEventHdr.setData("");

				EventMessageInvoker invoker = new EventMessageInvoker();
				Event event = invoker.processEventMessage(nsrEventHdr);

				Gson gson = new Gson();
				System.out.println("--->> Event OO:" + gson.toJson(event) + "\n");

			}
		} while (!rsvLevel.equalsIgnoreCase("E"));

	}

}
