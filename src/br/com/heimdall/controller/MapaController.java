package br.com.heimdall.controller;

import br.com.heimdall.model.Lotacao;
import br.com.heimdall.model.Sala;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class MapaController implements Serializable {

    private List<Lotacao> lotacoes;
    private List<Sala> listSala;

    @PostConstruct
    public void init() {
        Sala sala1 = new Sala(1, "Sala de Aula", 2, 1, 1, 1);
        Sala sala2 = new Sala(2, "Sala de Aula", 2, 1, 1, 1);
        Sala sala3 = new Sala(3, "Sala de Aula", 2, 1, 1, 1);
        Sala sala4 = new Sala(4, "Sala de Aula", 2, 1, 1, 1);
        Sala sala5 = new Sala(5, "Sala de Aula", 2, 1, 1, 1);
        Sala sala6 = new Sala(6, "Sala de Aula", 2, 1, 1, 1);
        Sala sala7 = new Sala(7, "Sala de Aula", 2, 1, 1, 1);
        Sala sala8 = new Sala(8, "Sala de Aula", 2, 1, 1, 1);
        Sala sala9 = new Sala(9, "Sala de Aula", 2, 1, 1, 1);
        Sala sala10 = new Sala(10, "Sala de Aula", 2, 1, 1, 1);
        Sala sala11 = new Sala(11, "Sala de Aula", 2, 1, 1, 1);
        Sala sala12 = new Sala(12, "Sala de Aula", 2, 1, 1, 1);
        Sala sala13 = new Sala(13, "Sala de Aula", 2, 1, 1, 1);

        getListSala().add(sala1);
        getListSala().add(sala2);
        getListSala().add(sala3);
        getListSala().add(sala4);
        getListSala().add(sala5);
        getListSala().add(sala6);
        getListSala().add(sala7);
        getListSala().add(sala8);
        getListSala().add(sala9);
        getListSala().add(sala10);
        getListSala().add(sala11);
        getListSala().add(sala12);
        getListSala().add(sala13);
    }


    public String buscaCursoSala() {
        return "SI";
    }

    public String buscaDisciplinaSala() {
        return "Disciplina Teste";
    }

    public List<Lotacao> getLotacoes() {
        if (lotacoes == null)
            lotacoes = new ArrayList<>();
        return lotacoes;
    }

    public void setLotacoes(List<Lotacao> lotacoes) {
        this.lotacoes = lotacoes;
    }

    public List<Sala> getListSala() {
        if (listSala == null)
            listSala = new ArrayList<>();
        return listSala;
    }

    public void setListSala(List<Sala> listSala) {
        this.listSala = listSala;
    }
}
