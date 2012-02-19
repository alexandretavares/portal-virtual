package br.ueg.portalVirtual.control;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import br.ueg.portalVirtual.annotation.RequiredField;
import br.ueg.portalVirtual.model.Entity;

public class ValidatorControl {

	private List<String> emptyFields;

	public ValidatorControl() {
		emptyFields = new ArrayList<String>();
	}

	@SuppressWarnings("rawtypes")
	public boolean isEmpty(Entity entity) {
		clean();
		boolean empty = false;

		Class entityCalss = entity.getClass();
		Field[] fields = entityCalss.getDeclaredFields();

		for (Field currentField : fields) {
			try {
				currentField.getAnnotation(RequiredField.class);
				Object fieldValue = getField(entity, currentField.getName());

				if (fieldValue == null || fieldValue.equals("")) {
					empty = true;
					emptyFields.add(currentField.getName());
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		return empty;
	}

	public boolean isEmpty(String value) {
		clean();
		boolean empty = false;

		if (value == null || value.equals("")) {
			empty = true;
			emptyFields.add("Busca");
		}

		return empty;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Object getField(Entity entity, String fieldName)
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {

		Class entityClass = entity.getClass();
		Method method = entityClass.getMethod("get"
				+ fieldName.substring(0, 1).toUpperCase()
				+ fieldName.substring(1));

		return method.invoke(entity);
	}

	public void clean() {
		emptyFields.clear();
	}

	public List<String> getEmptyFields() {
		return emptyFields;
	}
}
