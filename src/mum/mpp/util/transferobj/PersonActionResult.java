package mum.mpp.util.transferobj;

import mum.mpp.model.Person;

public class PersonActionResult {

	private boolean result;
	private String  actionMessage;

	
	
	public boolean isResult() {
			return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getActionMessage() {
		return actionMessage;
	}
	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}
	
}
