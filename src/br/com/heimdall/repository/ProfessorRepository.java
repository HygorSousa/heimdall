package br.com.heimdall.repository;

import br.com.heimdall.model.Professor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProfessorRepository extends DefaultRepository<Professor> {

    public ProfessorRepository(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Professor> getModelClass() {
        return Professor.class;
    }

    @Override
    public List<Object> buscarLazy(String search, Integer first, Integer pageSize, Integer lim) {
        String colunas = " pro.id, pro.matricula, pes.nome ";
        Query query = getEntityManager().createNativeQuery(
                "select " + colunas +
                        "from professor pro " +
                        "inner join pessoa pes on pro.id = pes.id " +
                        "where (" +
                        "   pes.nome ilike ?1 or pes.cpf ilike ?1 or pro.matricula ilike ?1" +
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
                        "from professor pro " +
                        "inner join pessoa pes on pro.id = pes.id " +
                        "where (" +
                        "   pes.nome ilike ?1 or pes.cpf ilike ?1 or pro.matricula ilike ?1" +
                        ") ");
        query.setParameter(1, "%" + search + "%");

        return (Long) buscarResultadoUnico(query);
    }


    public List<Professor> buscarComplete(String search, Integer reg) {
        Query query = getEntityManager().createNativeQuery(
                "select pro.* " +
                        "from professor pro " +
                        "inner join pessoa p on pro.id = p.id " +
                        "where p.nome ILIKE ?1 " +
                        "order by p.nome " +
                        "limit ?2", Professor.class);
        query.setParameter(1, "%" + search + "%");
        query.setParameter(2, reg);

        return super.buscar(query);
    }

}
