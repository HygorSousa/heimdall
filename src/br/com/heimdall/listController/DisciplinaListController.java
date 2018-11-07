package br.com.heimdall.listController;

import br.com.heimdall.factory.JPAFactory;
import br.com.heimdall.model.Disciplina;
import br.com.heimdall.repository.DisciplinaRepository;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class DisciplinaListController extends DefaultListController<Disciplina> {

    public DisciplinaListController() {
        super(new DisciplinaRepository(JPAFactory.getEntityManager()),
                true, false, false, 450, "95%", "/listings/listagemDisciplina");
    }

}
