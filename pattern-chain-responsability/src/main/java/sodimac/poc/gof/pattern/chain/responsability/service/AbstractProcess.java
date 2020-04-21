package sodimac.poc.gof.pattern.chain.responsability.service;

import java.util.Arrays;

import sodimac.poc.gof.pattern.chain.responsability.dto.Event;
import sodimac.poc.gof.pattern.chain.responsability.enumeration.StatusLevelEnum;

public abstract class AbstractProcess {
	
	protected int level;
	// next element in chain or responsibility
	protected AbstractProcess nextProcess;

	public void setNextProcess(AbstractProcess nextLogger) {
		this.nextProcess = nextLogger;
	}

	public void processEvent(Event event) {
		
		if (validatedProcess(event.getStatus())) {
			createNewEvent(event);
			//nextProcess = null;
		}
		if (this.nextProcess != null) {
			this.nextProcess.processEvent(event);
		}
	}
	
	private Boolean validatedProcess(int statusReceived) {
		Boolean flag = Boolean.FALSE;
		for(StatusLevelEnum enumLevel: Arrays.asList(StatusLevelEnum.values())) {
			if(this.level == enumLevel.getLevel() && Arrays.asList(enumLevel.getGroupStatus()).contains(statusReceived)) {
				flag = Boolean.TRUE;
				break;
			}
		}		
		return flag;
	}
	
	abstract protected void createNewEvent(Event event);
}
