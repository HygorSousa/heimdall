package br.com.heimdall.controller;

import br.com.heimdall.model.Professor;
import br.com.heimdall.model.Telefone;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ProfessorController extends Controller<Professor> {

    private Telefone telefone;

    @Override
    public void limpar() {
        setEntity(new Professor());
    }

    @Override
    public Professor getEntity() {
        return null;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
}
