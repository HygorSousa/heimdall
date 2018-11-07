package br.com.heimdall.listController;

import br.com.heimdall.factory.JPAFactory;
import br.com.heimdall.model.MatrizCurricular;
import br.com.heimdall.repository.MatrizCurricularRepository;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class MatrizCurricularListController extends DefaultListController<MatrizCurricular> {

    public MatrizCurricularListController() {
        super(new MatrizCurricularRepository(JPAFactory.getEntityManager()),
                true, false, false, 450, "95%", "/listings/listagemMatrizCurricular");
    }

}
