package br.com.heimdall.controller;

import br.com.heimdall.model.Disciplina;
import br.com.heimdall.model.MatrizCurricular;
import br.com.heimdall.model.Professor;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class MatrizCurricularController extends Controller<MatrizCurricular> {


    public List<Disciplina> completeDisciplina() {
        return new ArrayList<>();
    }

    public List<Professor> completeProfessor() {
        return new ArrayList<>();
    }

    @Override
    public void limpar() {
        setEntity(new MatrizCurricular());
    }

    @Override
    public MatrizCurricular getEntity() {
        return null;
    }

}
