package br.ueg.portalVirtual.control;

import java.util.List;

public interface IControl<E> {

	public List<E> getListAll(E entity);

	public Long save(E entity);

	public void update(E entity);

	public List<E> findByCriteria(E entity, String value);

	public List<E> findByHQL(E entity, String value);

	public void delete(E entity);
}
