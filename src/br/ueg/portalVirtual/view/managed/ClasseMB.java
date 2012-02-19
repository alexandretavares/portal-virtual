package br.ueg.portalVirtual.view.managed;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import br.ueg.portalVirtual.control.Control;
import br.ueg.portalVirtual.model.Classe;
import br.ueg.portalVirtual.model.Filo;

@ManagedBean
@SessionScoped
public class ClasseMB extends MB<Classe> {
	
	private List<Filo> filos;
	private Control<Filo> localControl;

	public ClasseMB() {
		super();
		localControl = new Control<Filo>();
	}
	
	@Override
	protected void initializeEntity() {
		setEntity(new Classe());
	}

	public void listFilo(ActionEvent event) {
		filos = localControl.getListAll(new Filo());
	}

	public List<Filo> getFilos() {
		return filos;
	}

	public void setFilos(List<Filo> filos) {
		this.filos = filos;
	}
	
}
