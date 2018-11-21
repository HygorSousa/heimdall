package br.com.heimdall.repository;

import br.com.heimdall.model.Lotacao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class LotacaoRepository extends DefaultRepository<Lotacao> {

    public LotacaoRepository(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Lotacao> getModelClass() {
        return Lotacao.class;
    }

    @Override
    public List<Object> buscarLazy(String search, Integer first, Integer pageSize, Integer lim) {
        String colunas = " lot.id, sal.tiposala, sal.numerosala, pes.nome as responsavel," +
                " lot.horarioinicio, lot.quantidadehoras ";
        Query query = getEntityManager().createNativeQuery(
                "select " + colunas +
                        "from lotacao lot " +
                        "inner join sala sal on lot.idsala = sal.id " +
                        "inner join responsavel res on lot.idresponsavel = res.id " +
                        "inner join pessoa pes on res.id = pes.id " +
                        "where pes.nome ilike ?1 " +
                        "order by sal.tiposala, sal.numerosala");
        query.setParameter(1, "%" + search + "%");

        query.setFirstResult(first);
        query.setMaxResults(pageSize);

        return buscarSQL(query);
    }

    @Override
    public Long buscarTodosRegistros(String search) {
        String colunas = " count(1) as count ";
        Query query = getEntityManager().createNativeQuery(
                "select " + colunas +
                        "from lotacao lot " +
                        "inner join sala sal on lot.idsala = sal.id " +
                        "inner join responsavel res on lot.idresponsavel = res.id " +
                        "inner join pessoa pes on res.id = pes.id " +
                        "where pes.nome ilike ?1 ");
        query.setParameter(1, "%" + search + "%");

        return (Long) buscarResultadoUnico(query);
    }

    public String buscarDisciplinaSala(Integer sala) {
        Query query = getEntityManager().createQuery(
                "select " +
                        "lot.proposito.matrizCurricular.disciplina.nome " +
                        "from Lotacao lot " +
                        "where lot.sala.id = ?1 and " +
                        "CURRENT_DATE between lot.dataEntrada and lot.dataSaida and " +
                        "current_time > lot.horarioInicio ", Lotacao.class);
        query.setParameter(1, sala);

        return (String) buscarResultadoUnico(query);
    }
}
