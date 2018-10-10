package br.com.heimdall.controller;

import br.com.heimdall.model.Sala;

import javax.faces.bean.ViewScoped;
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
        return null;
    }
}
