package br.ueg.portalVirtual.persistence;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import br.ueg.portalVirtual.model.Entity;

public class GenericDAO<E extends Entity> implements IGenericDAO<E> {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public long save(E entity) {
		return (Long) hibernateTemplate.save(entity);
	}

	@Override
	public void update(E entity) {
		hibernateTemplate.update(entity);
	}

	@Override
	public void delete(E entity) {
		hibernateTemplate.delete(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<E> findByCriteria(E entity, String value) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(entity.getClass()).add(
						Restrictions.like(entity.getSearchColumnEntity(), "%"
								+ value + "%"));
		return hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<E> findByHQL(E entity, String value) {
		String hql = "from " + entity.getClass().getSimpleName() + " where "
				+ entity.getSearchColumnTable() + " like '%" + value + "%'";

		return hibernateTemplate.find(hql);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<E> getList(E entity) {
		return (List<E>) hibernateTemplate.loadAll(entity.getClass());
	}

}
