package br.ueg.portalVirtual.view.managed;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import br.ueg.portalVirtual.control.Control;
import br.ueg.portalVirtual.model.Filo;
import br.ueg.portalVirtual.model.Reino;

@ManagedBean
@SessionScoped
public class FiloMB extends MB<Filo> {

	private List<Reino> reinos;
	private Control<Reino> localControl;

	public FiloMB() {
		super();
		localControl = new Control<Reino>();
	}

	@Override
	protected void initializeEntity() {
		setEntity(new Filo());
	}

	public List<Reino> getReinos() {
		return reinos;
	}

	public void setReinos(List<Reino> reinos) {
		this.reinos = reinos;
	}

	public void listReino(ActionEvent event) {
		reinos = localControl.getListAll(new Reino());
	}

}
