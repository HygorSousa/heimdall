package br.com.heimdall.repository;

import br.com.heimdall.model.Responsavel;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ResponsavelRepository extends DefaultRepository<Responsavel> {

    public ResponsavelRepository(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Responsavel> getModelClass() {
        return Responsavel.class;
    }

    @Override
    public List<Object> buscarLazy(String search, Integer first, Integer pageSize, Integer lim) {
        String colunas = " res.id, pes.cpf, pes.nome ";
        Query query = getEntityManager().createNativeQuery(
                "select " + colunas +
                        "from responsavel res " +
                        "inner join pessoa pes on res.id = pes.id " +
                        "where (" +
                        "   pes.nome ilike ?1 or pes.cpf ilike ?1" +
                        ") " +
                        "order by pes.nome ");
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
                        "from responsavel res " +
                        "inner join pessoa pes on res.id = pes.id " +
                        "where (" +
                        "   pes.nome ilike ?1 or pes.cpf ilike ?1" +
                        ")");
        query.setParameter(1, "%" + search + "%");

        return (Long) buscarResultadoUnico(query);
    }

    public List<Responsavel> buscarComplete(String search, Integer reg) {
        Query query = getEntityManager().createNativeQuery(
                "select res.* " +
                        "from responsavel res " +
                        "inner join pessoa p on res.id = p.id " +
                        "where p.nome ILIKE ?1 " +
                        "order by p.nome " +
                        "limit ?2", Responsavel.class);
        query.setParameter(1, "%" + search + "%");
        query.setParameter(2, reg);

        return super.buscar(query);
    }

}
