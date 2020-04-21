package sodimac.poc.gof.pattern.strategy.service;

import sodimac.poc.gof.pattern.strategy.dto.ErrorNSR;
import sodimac.poc.gof.pattern.strategy.dto.NSREvent;

public class Context {

	private DataBaseStrategy strategy;

	public Context(DataBaseStrategy strategy) {
		this.strategy = strategy;
	}

	public Boolean saveDataStrategy(NSREvent event) {
		return strategy.saveData(event);
	}
	
	public Boolean saveErrorStrategy(ErrorNSR error) {
		return strategy.saveError(error);
	}
	
	public NSREvent getDataStrategy(NSREvent event) {
		return strategy.getDataEvent(event.getId());
	}
}
