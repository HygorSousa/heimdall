package br.com.heimdall.listController;

import br.com.heimdall.factory.JPAFactory;
import br.com.heimdall.model.Professor;
import br.com.heimdall.repository.ProfessorRepository;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ProfessorListController extends DefaultListController<Professor> {


    public ProfessorListController() {
        super(new ProfessorRepository(JPAFactory.getEntityManager()),
                true, false, false, 450, "95%", "/listings/listagemProfessor");
    }

    @Override
    public Professor getEntity() {
        return new Professor();
    }

}
