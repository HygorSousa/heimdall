package br.com.heimdall.controller;

import br.com.heimdall.listController.SalaListController;
import br.com.heimdall.model.Sala;
import br.com.heimdall.repository.SalaRepository;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class SalaController extends Controller<Sala> {

    public void abrirListSala() {
        SalaListController list = new SalaListController();
        list.openList(this::setEntity);
    }

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

    @Override
    public Sala incluir() {
        SalaRepository repository = new SalaRepository(getEntityManager());
        getEntity().setNumeroSala(repository.getNumeroSugestao());
        return super.incluir();
    }
}
