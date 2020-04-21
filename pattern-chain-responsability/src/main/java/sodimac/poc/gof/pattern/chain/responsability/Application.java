package sodimac.poc.gof.pattern.chain.responsability;

import java.util.Scanner;

import sodimac.poc.gof.pattern.chain.responsability.dto.Event;
import sodimac.poc.gof.pattern.chain.responsability.enumeration.Constants;
import sodimac.poc.gof.pattern.chain.responsability.service.AbstractProcess;
import sodimac.poc.gof.pattern.chain.responsability.service.impl.FulfillmentImpl;
import sodimac.poc.gof.pattern.chain.responsability.service.impl.PaymentImpl;
import sodimac.poc.gof.pattern.chain.responsability.service.impl.ShipmentLineImpl;

public class Application {

	private static AbstractProcess getChainOfProcess() {

		AbstractProcess payment = new PaymentImpl(Constants.LEVEL_ONE);
		AbstractProcess shipmentLine = new ShipmentLineImpl(Constants.LEVEL_TWO);
		AbstractProcess fulfillment = new FulfillmentImpl(Constants.LEVEL_THREE);

		payment.setNextProcess(shipmentLine);
		shipmentLine.setNextProcess(fulfillment);

		return payment;
	}

	public static void main(String[] args) {
		
		String statusOrder = "";
		do {
			System.out.println("-------- >>>>> Patron cadena de responsabilidad <<<<< --------: ");
			System.out.print("Ingrese el estatus de la orden de venta: ");
			Scanner entrada = new Scanner(System.in);
			statusOrder = entrada.nextLine();
			
			if(!statusOrder.equalsIgnoreCase("E")) {
				
				Event event = new Event();
				event.setId("a12dsrf-343f-sw35f-2325s-34");
				event.setSku("12345-k");
				event.setStatus(Integer.parseInt(statusOrder));
				
				AbstractProcess processChain = getChainOfProcess();
				
				processChain.processEvent(event);
			}						
			
		} while (!statusOrder.equalsIgnoreCase("E"));
		
		
	}

}
