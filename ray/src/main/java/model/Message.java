package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	String sender;
	String receiver;
	
	public Message() {
		
	}

    public Message(String sender, String receiver) {
    	this.sender = sender;
    	this.receiver = receiver;
    }
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
}
