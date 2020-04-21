package sodimac.poc.gof.pattern.strategy.service;

import sodimac.poc.gof.pattern.strategy.dto.ErrorNSR;
import sodimac.poc.gof.pattern.strategy.dto.NSREvent;

public interface DataBaseStrategy {
	
	public Boolean saveData(NSREvent error);
	
	public Boolean saveError(ErrorNSR error);
	
	public NSREvent getDataEvent(String orderNumber);
	
}
