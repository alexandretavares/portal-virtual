package br.ueg.portalVirtual.view.control;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.ueg.portalVirtual.control.MessagesControl;

public class MessagesWeb extends MessagesControl {

	public MessagesWeb() {
		super();
	}
	
	@Override
	public void addMessage(String message) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", getMessage(message));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
