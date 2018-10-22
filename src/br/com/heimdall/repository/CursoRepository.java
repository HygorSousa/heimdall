package br.com.heimdall.repository;

import br.com.heimdall.model.Curso;

import javax.persistence.EntityManager;

public class CursoRepository extends DefaultRepository<Curso> {

    public CursoRepository(EntityManager em) {
        super(em);
    }

    @Override
    protected Class<Curso> getModelClass() {
        return Curso.class;
    }


}
