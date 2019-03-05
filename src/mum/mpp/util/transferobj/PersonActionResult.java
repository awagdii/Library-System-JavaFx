package mum.mpp.util.transferobj;

import mum.mpp.model.Person;

public class PersonActionResult {

	private boolean result;
	private String  actionMessage;
	private Person person;
	
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
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
