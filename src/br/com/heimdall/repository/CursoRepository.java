package br.com.heimdall.repository;

import br.com.heimdall.model.Curso;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CursoRepository extends DefaultRepository<Curso> {

    public CursoRepository(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Curso> getModelClass() {
        return Curso.class;
    }

    @Override
    public List<Object> buscarLazy(String search, Integer first, Integer pageSize, Integer lim) {
        Query query = getEntityManager().createNativeQuery(
                "select " +
                        "   cur.id, cur.nome " +
                        "from  curso cur " +
                        "where cur.nome ilike ?1 " +
                        "ORDER BY cur.nome");
        query.setParameter(1, "%" + search + "%");

        query.setFirstResult(first);
        query.setMaxResults(pageSize);

        return buscarSQL(query);
    }

    @Override
    public Long buscarTodosRegistros(String search) {
        Query query = getEntityManager().createNativeQuery(
                "select " +
                        "   count(1) as count " +
                        "from  curso cur " +
                        "where cur.nome ilike ?1 ");
        query.setParameter(1, "%" + search + "%");

        return (Long) buscarResultadoUnico(query);
    }


}
