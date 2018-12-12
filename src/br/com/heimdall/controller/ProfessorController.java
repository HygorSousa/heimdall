package br.com.heimdall.controller;

import br.com.heimdall.application.Util;
import br.com.heimdall.factory.ProfessorFactory;
import br.com.heimdall.listController.ProfessorListController;
import br.com.heimdall.model.Professor;
import br.com.heimdall.model.Telefone;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ProfessorController extends Controller<Professor> {

    private Telefone telefone;

    @PostConstruct
    public void init() {
        getEntity().getPessoa().getUsuario().setPessoa(getEntity().getPessoa());
    }

    public void abrirListProfessor() {
        ProfessorListController list = new ProfessorListController();
        list.openList(this::setEntity);
    }

    @Override
    public Professor incluir() {
        getEntity().getPessoa().getUsuario().setLogin(getEntity().getPessoa().getEmail());
        getEntity().getPessoa().getUsuario().setSenha(Util.encryptPassword(getEntity().getPessoa().getCpf()));
        return super.incluir();
    }

    @Override
    public void limpar() {
        setEntity(new Professor());
    }

    @Override
    public Professor getEntity() {
        if (entity == null)
            entity = ProfessorFactory.initialize();
        return entity;
    }

    public Telefone getTelefone() {
        if (telefone == null)
            telefone = new Telefone();
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
}
