package br.com.heimdall.controller;

import br.com.heimdall.factory.MatrizCurricularFactory;
import br.com.heimdall.model.Disciplina;
import br.com.heimdall.model.MatrizCurricular;
import br.com.heimdall.model.Professor;
import br.com.heimdall.repository.DisciplinaRepository;
import br.com.heimdall.repository.ProfessorRepository;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class MatrizCurricularController extends Controller<MatrizCurricular> {


    public List<Disciplina> completeDisciplina(String query) {
        DisciplinaRepository repository = new DisciplinaRepository(getEntityManager());
        return repository.buscarComplete(query, 5);
    }

    public List<Professor> completeProfessor(String query) {
        ProfessorRepository repository = new ProfessorRepository(getEntityManager());
        return repository.buscarComplete(query, 5);
    }

    @Override
    public void limpar() {
        setEntity(new MatrizCurricular());
    }

    @Override
    public MatrizCurricular incluir() {
        getEntity().setCurso(getEntity().getDisciplina().getCurso());
        return super.incluir();
    }

    @Override
    public MatrizCurricular getEntity() {
        if (entity == null)
            entity = MatrizCurricularFactory.initialize();
        return entity;
    }

}
