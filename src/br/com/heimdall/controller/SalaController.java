package br.com.heimdall.controller;

import br.com.heimdall.model.Sala;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class SalaController extends Controller<Sala> {
    @Override
    public void limpar() {
        setEntity(new Sala());
    }

    @Override
    public Sala getEntity() {
        if (entity == null)
            entity = new Sala();
        return entity;
    }
}
