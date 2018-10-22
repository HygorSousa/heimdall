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
