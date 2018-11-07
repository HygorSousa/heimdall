package br.com.heimdall.repository;

import br.com.heimdall.model.Sala;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class SalaRepository extends DefaultRepository<Sala> {

    public SalaRepository(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Sala> getModelClass() {
        return Sala.class;
    }

    @Override
    public List<Object> buscarLazy(String search, Integer first, Integer pageSize, Integer lim) {
        String colunas = " sal.id, sal.tiposala, sal.numerosala, sal.descricao ";
        Query query = getEntityManager().createNativeQuery(
                "select " + colunas +
                        "from sala sal " +
                        "where (" +
                        "   sal.tiposala = ?1 or sal.bloco =?1 or sal.andar = ?1 or sal.statussala =?1" +
                        ") " +
                        "order by sal.tiposala, sal.numerosala ");
        query.setParameter(1, search.equals("") ? 0 : Integer.parseInt(search));

        query.setFirstResult(first);
        query.setMaxResults(pageSize);

        return buscarSQL(query);
    }

    @Override
    public Long buscarTodosRegistros(String search) {
        String colunas = " count(1) as count ";
        Query query = getEntityManager().createNativeQuery(
                "select " + colunas +
                        "from sala sal " +
                        "where (" +
                        "   sal.tiposala = ?1 or sal.bloco =?1 or sal.andar = ?1 or sal.statussala =?1" +
                        ") ");
        query.setParameter(1, search.equals("") ? 0 : Integer.parseInt(search));

        return (Long) buscarResultadoUnico(query);
    }

    public Integer getNumeroSugestao() {
        Query query = getEntityManager().createNativeQuery(
                "select max(CAST(coalesce(sala.numerosala, '0') AS INTEGER)) AS numero  " +
                        "from sala");
        Integer result = (Integer) buscarResultadoUnico(query);
        return result == null ? 1 : result + 1;
    }


}
