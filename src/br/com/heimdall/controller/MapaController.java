package br.com.heimdall.controller;

import br.com.heimdall.factory.JPAFactory;
import br.com.heimdall.model.Lotacao;
import br.com.heimdall.model.Sala;
import br.com.heimdall.repository.LotacaoRepository;
import br.com.heimdall.repository.SalaRepository;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
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
        EntityManager em = JPAFactory.getEntityManager();
        SalaRepository salaRepository = new SalaRepository(em);
        LotacaoRepository lotacaoRepository = new LotacaoRepository(em);
        setListSala(salaRepository.lista());
        setLotacoes(lotacaoRepository.lista());
    }

    public String buscaCursoSala() {
        return "SI";
    }

    public String buscaDisciplinaSala(Sala sala) {
        LotacaoRepository repository = new LotacaoRepository(JPAFactory.getEntityManager());
        return repository.buscarDisciplinaSala(sala.getId());
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
