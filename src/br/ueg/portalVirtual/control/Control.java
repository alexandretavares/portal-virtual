package br.ueg.portalVirtual.control;

import java.util.List;

import br.ueg.portalVirtual.model.Entity;
import br.ueg.portalVirtual.persistence.GenericDAO;
import br.ueg.portalVirtual.sets.SpringFactory;
import br.ueg.portalVirtual.view.control.MessagesWeb;

public class Control<E extends Entity> implements IControl<E> {

	private GenericDAO<E> persistence;
	private ValidatorControl validator;
	private MessagesControl messages;

	@SuppressWarnings("unchecked")
	public Control() {
		persistence = (GenericDAO<E>) SpringFactory.getInstance().getBean(
				"genericDAO", GenericDAO.class);

		validator = new ValidatorControl();
		messages = new MessagesWeb();
	}

	@Override
	public List<E> getListAll(E entity) {
		return persistence.getList(entity);
	}

	@Override
	public Long save(E entity) {
		if (!validator.isEmpty(entity)) {
			return persistence.save(entity);
		} else {
			List<String> emptyFields = validator.getEmptyFields();

			for (int i = 0; i < emptyFields.size(); i++) {
				messages.addMessage(emptyFields.get(i));
			}
		}

		return (long) 0;
	}

	@Override
	public void update(E entity) {
		if (!validator.isEmpty(entity)) {
			persistence.update(entity);
		} else {
			List<String> emptyFields = validator.getEmptyFields();

			for (int i = 0; i < emptyFields.size(); i++) {
				messages.addMessage(emptyFields.get(i));
			}
		}
	}

	@Override
	public List<E> findByCriteria(E entity, String value) {
		if (!validator.isEmpty(value)) {
			return persistence.findByCriteria(entity, value);
		} else {
			messages.addMessage(validator.getEmptyFields().get(0));
		}
		return null;
	}

	@Override
	public List<E> findByHQL(E entity, String value) {
		if (!validator.isEmpty(value)) {
			return persistence.findByHQL(entity, value);
		} else {
			messages.addMessage(validator.getEmptyFields().get(0));
		}
		return null;
	}

	@Override
	public void delete(E entity) {
		persistence.delete(entity);
	}

}
