package br.com.heimdall.repository;

import br.com.heimdall.model.Disciplina;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DisciplinaRepository extends DefaultRepository<Disciplina> {

    public DisciplinaRepository(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Disciplina> getModelClass() {
        return Disciplina.class;
    }

    public List<Disciplina> buscarComplete(String search, Integer reg) {
        Query query = getEntityManager().createNativeQuery(
                "select dis.* " +
                        "from disciplina dis " +
                        "where dis.nome ILIKE ?1 " +
                        "order by dis.nome " +
                        "limit ?2", Disciplina.class);
        query.setParameter(1, "%" + search + "%");
        query.setParameter(2, reg);

        return super.buscar(query);
    }
}
