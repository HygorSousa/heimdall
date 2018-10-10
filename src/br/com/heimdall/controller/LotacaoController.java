package br.com.heimdall.controller;

import br.com.heimdall.model.Disciplina;
import br.com.heimdall.model.Lotacao;
import br.com.heimdall.model.Professor;
import br.com.heimdall.model.Sala;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class LotacaoController extends Controller<Lotacao> {

    private List<Sala> listaSalas;


    public List<Disciplina> completeResponsavel() {
        return new ArrayList<>();
    }

    public List<Professor> completeProfessor() {
        return new ArrayList<>();
    }

    @Override
    public void limpar() {
        setEntity(new Lotacao());
    }

    @Override
    public Lotacao getEntity() {
        return null;
    }

    public List<Sala> getListaSalas() {
        return listaSalas;
    }

    public void setListaSalas(List<Sala> listaSalas) {
        this.listaSalas = listaSalas;
    }
}
