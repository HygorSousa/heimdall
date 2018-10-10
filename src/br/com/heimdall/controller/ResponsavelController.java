package br.com.heimdall.controller;

import br.com.heimdall.model.Responsavel;
import br.com.heimdall.model.Telefone;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ResponsavelController extends Controller<Responsavel> {

    private Telefone telefone;

    @Override
    public void limpar() {
        setEntity(new Responsavel());
    }

    @Override
    public Responsavel getEntity() {
        return null;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
}
