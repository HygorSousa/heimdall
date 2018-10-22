package br.com.heimdall.controller;

import br.com.heimdall.factory.JPAFactory;
import br.com.heimdall.listController.DisciplinaListController;
import br.com.heimdall.model.Curso;
import br.com.heimdall.model.Disciplina;
import br.com.heimdall.repository.CursoRepository;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class DisciplinaController extends Controller<Disciplina> {

    private List<Curso> listaCursos;

    @PostConstruct
    public void init() {
        CursoRepository repository = new CursoRepository(JPAFactory.getEntityManager());
        setListaCursos(repository.lista());
    }

    public void abrirListDisciplina() {
        DisciplinaListController listController = new DisciplinaListController();
        listController.openList(this::setEntity);
    }

    @Override
    public void limpar() {
        setEntity(new Disciplina());
    }

    @Override
    public Disciplina getEntity() {
        if (entity == null)
            entity = new Disciplina();
        return entity;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
}
