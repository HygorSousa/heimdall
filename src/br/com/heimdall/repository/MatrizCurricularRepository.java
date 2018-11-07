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

    @Override
    public List<Object> buscarLazy(String search, Integer first, Integer pageSize, Integer lim) {
        String colunas = " mat.id, dis.nome as disciplina, cur.nome as curso, mat.cargahoraria ";
        Query query = getEntityManager().createNativeQuery(
                "select " + colunas +
                        "from matrizcurricular mat " +
                        "inner join disciplina dis on mat.iddisciplina = dis.id " +
                        "inner join curso cur on dis.idcurso = cur.id " +
                        "where (dis.nome ilike ?1 or cur.nome ilike ?1) " +
                        "order by dis.nome ");
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
                        "from matrizcurricular mat " +
                        "inner join disciplina dis on mat.iddisciplina = dis.id " +
                        "inner join curso cur on dis.idcurso = cur.id " +
                        "where (dis.nome ilike ?1 or cur.nome ilike ?1)");
        query.setParameter(1, "%" + search + "%");

        return (Long) buscarResultadoUnico(query);
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
