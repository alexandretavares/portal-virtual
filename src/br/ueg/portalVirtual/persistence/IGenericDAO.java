package br.ueg.portalVirtual.persistence;

import java.util.List;

import br.ueg.portalVirtual.model.Entity;

public interface IGenericDAO<E extends Entity> {
	public long save(E entity);

	public void update(E entity);

	public void delete(E entity);

	public List<E> findByCriteria(E entity, String value);

	public List<E> findByHQL(E entity, String value);

	List<E> getList(E entity);

}
