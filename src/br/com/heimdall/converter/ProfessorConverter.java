package br.com.heimdall.converter;

import br.com.heimdall.factory.JPAFactory;
import br.com.heimdall.model.Professor;
import br.com.heimdall.repository.ProfessorRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Professor.class)
public class ProfessorConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        ProfessorRepository repository = new ProfessorRepository(JPAFactory.getEntityManager());
        return repository.buscar(Integer.parseInt(arg2));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        if (arg2 != null)
            return ((Professor) arg2).getId() == null ? "" : ((Professor) arg2).getId().toString();
        return "";
    }
}