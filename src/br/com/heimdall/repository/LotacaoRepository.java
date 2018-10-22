package br.com.heimdall.repository;

import br.com.heimdall.model.Lotacao;

import javax.persistence.EntityManager;

public class LotacaoRepository extends DefaultRepository<Lotacao> {

    public LotacaoRepository(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Lotacao> getModelClass() {
        return Lotacao.class;
    }


}
