package fr.orsys.sms.business;

import java.util.List;

public class MessageBody {
	private List<String> receivers;
	private String message;
	private boolean senderForResponse;
	
	
	public List<String> getReceivers() {
		return receivers;
	}
	public void setReceivers(List<String> receivers) {
		this.receivers = receivers;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void addReceiver(String s) {
		this.receivers.add(s);
	}
		
	public boolean isSenderForResponse() {
		return senderForResponse;
	}
	
	public void setSenderForResponse(boolean senderForResponse) {
		this.senderForResponse = senderForResponse;
	}
	
	public MessageBody(List<String> receivers, String message, boolean senderForResponse) {
		super();
		this.senderForResponse = senderForResponse;
		this.receivers = receivers;
		this.message = message;
	}
	
	
}
