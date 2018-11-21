package br.com.heimdall.converter;

import br.com.heimdall.factory.JPAFactory;
import br.com.heimdall.model.Sala;
import br.com.heimdall.repository.SalaRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "salaConverter")
public class SalaConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        SalaRepository repository = new SalaRepository(JPAFactory.getEntityManager());
        return repository.buscar(Integer.parseInt(arg2));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        if (arg2 != null)
            return ((Sala) arg2).getId() == null ? "" : ((Sala) arg2).getId().toString();
        return "";
    }
}