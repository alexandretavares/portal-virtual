package br.ueg.portalVirtual.view.managed;

import java.util.List;

import javax.faces.event.ActionEvent;

import br.ueg.portalVirtual.control.Control;
import br.ueg.portalVirtual.model.Entity;

public abstract class MB<E extends Entity> {

	private Control<E> control;
	private boolean listing = false;
	private E entity;
	private List<E> listEntity;
	private String busca;

	public MB() {
		control = new Control<E>();
		initializeEntity();
	}

	protected Control<E> getControl() {
		return control;
	}

	protected void setControl(Control<E> control) {
		this.control = control;
	}

	public boolean isListing() {
		return listing;
	}

	public void setListing(boolean listing) {
		this.listing = listing;
	}

	public E getEntity() {
		return entity;
	}

	public void setEntity(E entity) {
		this.entity = entity;
	}

	public List<E> getListEntity() {
		return listEntity;
	}

	public void setListEntity(List<E> listEntity) {
		this.listEntity = listEntity;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public void list() {
		setListing(true);
		listEntity = control.getListAll(getEntity());
	}

	public void saveOrUpdate() {
		if (entity.getId() == 0) {
			control.save(entity);
		} else {
			control.update(entity);
		}
		initializeEntity();
		verifyListing();
	}

	public void delete() {
		control.delete(entity);
		verifyListing();
	}

	public void find() {
		setListing(true);
		listEntity = control.findByCriteria(getEntity(), busca);
	}

	private void verifyListing() {
		if (listing) {
			listEntity = control.getListAll(getEntity());
		}
	}

	public void cancel(ActionEvent event) {
		initializeEntity();
	}

	protected abstract void initializeEntity();
}
