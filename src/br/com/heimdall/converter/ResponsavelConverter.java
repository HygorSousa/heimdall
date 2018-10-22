package br.com.heimdall.converter;

import br.com.heimdall.factory.JPAFactory;
import br.com.heimdall.model.Responsavel;
import br.com.heimdall.repository.ResponsavelRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "responsavelConverter")
public class ResponsavelConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        ResponsavelRepository repository = new ResponsavelRepository(JPAFactory.getEntityManager());
        return repository.buscar(Integer.parseInt(arg2));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        if (arg2 != null)
            return ((Responsavel) arg2).getId() == null ? "" : ((Responsavel) arg2).getId().toString();
        return "";
    }
}