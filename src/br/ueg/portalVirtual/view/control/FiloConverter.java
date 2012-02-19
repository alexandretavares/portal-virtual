package br.ueg.portalVirtual.view.control;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ueg.portalVirtual.model.Filo;
import br.ueg.portalVirtual.model.Reino;

@FacesConverter(value = "filoconverter")
public class FiloConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {

		if (value != null && !value.equals("") && value.indexOf(":") != -1) {
			Object[] values = value.split(":");

			return new Filo(Long.parseLong(values[0].toString()),
					values[1].toString(), new Reino(Long.parseLong(values[2].toString()), values[3].toString()));
		}

		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		try {
			Filo optionItem = (Filo) value;
			return optionItem.getId() + ":" + optionItem.getFilo() + ":"
					+ optionItem.getReino().getId() + ":" + optionItem.getReino().getReino();
		} catch (Exception e) {
		}

		return (String) value;
	}

}
