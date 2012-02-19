package br.ueg.portalVirtual.view.managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ueg.portalVirtual.model.Reino;

@ManagedBean
@SessionScoped
public class ReinoMB extends MB<Reino> {

	public ReinoMB() {
		super();
	}
	
	@Override
	protected void initializeEntity() {
		setEntity(new Reino());
	}

}
