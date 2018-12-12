package br.com.heimdall.controller;

import br.com.heimdall.factory.JPAFactory;
import br.com.heimdall.model.Curso;
import br.com.heimdall.model.DiaSemana;
import br.com.heimdall.model.Lotacao;
import br.com.heimdall.model.Sala;
import br.com.heimdall.repository.CursoRepository;
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

    private Integer curso;
    private Integer bloco;
    private Integer diaSemana;

    private List<Lotacao> lotacoes;
    private List<Sala> listSala;
    private List<Curso> listCurso;


    @PostConstruct
    public void init() {
        EntityManager em = JPAFactory.getEntityManager();
        SalaRepository salaRepository = new SalaRepository(em);
        LotacaoRepository lotacaoRepository = new LotacaoRepository(em);
        CursoRepository cursoRepository = new CursoRepository(em);

        setListSala(salaRepository.buscarSalas(null, null, null));
        setLotacoes(lotacaoRepository.lista());
        setListCurso(cursoRepository.lista());
    }

    public String buscaCursoSala() {
        return "SI";
    }

    public String buscaDisciplinaSala(Sala sala) {
        LotacaoRepository repository = new LotacaoRepository(JPAFactory.getEntityManager());
        return repository.buscarDisciplinaSala(sala.getId());
    }

    public void filtrar() {
        SalaRepository repository = new SalaRepository(JPAFactory.getEntityManager());
        setListSala(repository.buscarSalas(curso, bloco, diaSemana));
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    public Integer getBloco() {
        return bloco;
    }

    public void setBloco(Integer bloco) {
        this.bloco = bloco;
    }

    public Sala.Bloco[] getBlocoValues() {
        return Sala.Bloco.values();
    }

    public Integer getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Integer diaSemana) {
        this.diaSemana = diaSemana;
    }

    public DiaSemana[] getDiaSemanaValues() {
        return DiaSemana.values();
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

    public List<Curso> getListCurso() {
        if (listCurso == null)
            listCurso = new ArrayList<>();
        return listCurso;
    }

    public void setListCurso(List<Curso> listCurso) {
        this.listCurso = listCurso;
    }
}
