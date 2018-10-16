package br.com.heimdall.controller;

import br.com.heimdall.model.Curso;
import br.com.heimdall.model.Disciplina;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class DisciplinaController extends Controller<Disciplina> {

    private List<Curso> listaCursos;

    @Override
    public void limpar() {
        setEntity(new Disciplina());
    }

    @Override
    public Disciplina getEntity() {
        return null;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
}
