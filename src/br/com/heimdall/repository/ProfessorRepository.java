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
