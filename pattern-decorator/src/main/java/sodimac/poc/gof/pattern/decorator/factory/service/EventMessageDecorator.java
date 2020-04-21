package sodimac.poc.gof.pattern.decorator.factory.service;

public abstract class EventMessageDecorator extends EventMessage {
	protected EventMessage eventMessage;

	public EventMessageDecorator(EventMessage eventMessage){
	      this.eventMessage = eventMessage;
	   }
}
