package br.com.heimdall.listController;

import br.com.heimdall.factory.JPAFactory;
import br.com.heimdall.model.Curso;
import br.com.heimdall.repository.CursoRepository;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CursoListController extends DefaultListController<Curso> {

    public CursoListController() {
        super(new CursoRepository(JPAFactory.getEntityManager()),
                true, false, false, 450, "95%", "/listings/listagemCurso");
    }

}
