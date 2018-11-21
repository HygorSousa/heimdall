package br.com.heimdall.converter;

import br.com.heimdall.factory.JPAFactory;
import br.com.heimdall.model.MatrizCurricular;
import br.com.heimdall.repository.MatrizCurricularRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "matrizCurricularConverter")
public class MatrizCurricularConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        MatrizCurricularRepository repository = new MatrizCurricularRepository(JPAFactory.getEntityManager());
        return repository.buscar(Integer.parseInt(arg2));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        if (arg2 != null)
            return ((MatrizCurricular) arg2).getId() == null ? "" : ((MatrizCurricular) arg2).getId().toString();
        return "";
    }
}