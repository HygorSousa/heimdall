package br.com.heimdall.repository;

import br.com.heimdall.model.Sala;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

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

    public List<Sala> buscarSalas(Object... params) {
        Integer idCurso = Optional.ofNullable(params).map(o -> (Integer) o[0]).orElse(null);
        Integer bloco = Optional.ofNullable(params).map(o -> (Integer) o[1]).orElse(null);
        Integer diaSemana = Optional.ofNullable(params).map(o -> (Integer) o[2]).orElse(null);
        Query query = getEntityManager().createNativeQuery(
                "select " +
                        "sal.* " +
                        "from lotacao lot " +
                        "inner join sala sal on lot.idsala = sal.id " +
                        "inner join proposito pro on lot.idproposito = pro.id " +
                        "inner join matrizcurricular mat on pro.idmatrizcurricular = mat.id " +
                        "where " +
                        "(?1 isnull or mat.idcurso = ?1) and " +
                        "(?2 isnull or sal.bloco = ?2) and " +
                        "(?3 isnull or lot.diasemana = ?3) and " +
                        "CURRENT_DATE between lot.dataEntrada and lot.dataSaida and " +
                        "CURRENT_TIME > lot.horarioInicio ", Sala.class);

        query.setHint(QueryHints.BIND_PARAMETERS, HintValues.FALSE);
        query.setParameter(1, idCurso);
        query.setParameter(2, bloco);
        query.setParameter(3, diaSemana);

        return buscar(query);
    }


}
