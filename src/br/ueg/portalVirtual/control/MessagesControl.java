package br.ueg.portalVirtual.control;

import java.util.ResourceBundle;

public abstract class MessagesControl {
	
	private static ResourceBundle messages;
	
	public MessagesControl() {
		messages = ResourceBundle.getBundle("br/ueg/portalVirtual/bundle/messages");
	}
	
	protected String getMessage(String typeMessage) {
		return messages.getString("erro_" + typeMessage);
	}
	
	public abstract void addMessage(String message);
}
