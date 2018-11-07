package br.com.heimdall.controller;

import br.com.heimdall.factory.LotacaoFactory;
import br.com.heimdall.listController.LotacaoListController;
import br.com.heimdall.model.Lotacao;
import br.com.heimdall.model.MatrizCurricular;
import br.com.heimdall.model.Responsavel;
import br.com.heimdall.model.Sala;
import br.com.heimdall.repository.MatrizCurricularRepository;
import br.com.heimdall.repository.ResponsavelRepository;
import br.com.heimdall.repository.SalaRepository;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class LotacaoController extends Controller<Lotacao> {

    private List<Sala> listaSalas;

    @PostConstruct
    public void init() {
        SalaRepository repository = new SalaRepository(getEntityManager());
        setListaSalas(repository.lista());
    }

    public void abrirListLotacao() {
        LotacaoListController list = new LotacaoListController();
        list.openList(this::setEntity);
    }

    public List<Responsavel> completeResponsavel(String query) {
        ResponsavelRepository repository = new ResponsavelRepository(getEntityManager());
        return repository.buscarComplete(query, 5);
    }

    public List<MatrizCurricular> completeMatrizCurricular(String query) {
        MatrizCurricularRepository repository = new MatrizCurricularRepository(getEntityManager());
        return repository.buscarComplete(query, 5);
    }

    @Override
    public void limpar() {
        setEntity(new Lotacao());
    }

    @Override
    public Lotacao getEntity() {
        if (entity == null)
            entity = LotacaoFactory.initialize();
        return entity;
    }

    public List<Sala> getListaSalas() {
        return listaSalas;
    }

    public void setListaSalas(List<Sala> listaSalas) {
        this.listaSalas = listaSalas;
    }
}
