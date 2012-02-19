package br.ueg.portalVirtual.view.control;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import br.ueg.portalVirtual.model.Reino;

@FacesConverter(value = "reinoconverter")
public class ReinoConverter implements javax.faces.convert.Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		int index = value.indexOf(":");

		if (index != -1) {
			return new Reino(Long.parseLong(value.substring(0, index)),
					value.substring(index + 1));
		}

		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		try {
			Reino optionItem = (Reino) value;
			return optionItem.getId() + ":" + optionItem.getReino();
		} catch (Exception e) {
		}

		return (String) value;
	}

}
