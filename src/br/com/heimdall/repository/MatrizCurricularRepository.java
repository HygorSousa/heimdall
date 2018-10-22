package br.com.heimdall.repository;

import br.com.heimdall.model.MatrizCurricular;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MatrizCurricularRepository extends DefaultRepository<MatrizCurricular> {

    public MatrizCurricularRepository(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<MatrizCurricular> getModelClass() {
        return MatrizCurricular.class;
    }

    public List<MatrizCurricular> buscarComplete(String search, Integer reg) {
        Query query = getEntityManager().createNativeQuery(
                "select mat.* " +
                        "from matrizcurricular mat " +
                        "inner join disciplina dis on mat.iddisciplina = dis.id " +
                        "where dis.nome ILIKE ?1 " +
                        "order by dis.nome " +
                        "limit ?2", MatrizCurricular.class);
        query.setParameter(1, "%" + search + "%");
        query.setParameter(2, reg);

        return super.buscar(query);
    }

}
