package br.com.heimdall.controller;

import br.com.heimdall.listController.CursoListController;
import br.com.heimdall.model.Curso;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CursoController extends Controller<Curso> {

    @PostConstruct
    public void init() {
    }

    public void abrirListCurso() {
        CursoListController list = new CursoListController();
        list.openList(this::setEntity);
    }

    @Override
    public void limpar() {
        setEntity(new Curso());
    }

    @Override
    public Curso getEntity() {
        if (entity == null)
            entity = new Curso();
        return entity;
    }
}
