package br.com.heimdall.factory;

import br.com.heimdall.model.MatrizCurricular;

public class MatrizCurricularFactory {
    public static MatrizCurricular initialize() {
        MatrizCurricular t = new MatrizCurricular();
        t.setCurso(CursoFactory.initialize());
        t.setDisciplina(DisciplinaFactory.initialize());
        t.setProfessor(ProfessorFactory.initialize());
        t.setSemestre(SemestreFactory.initialize());
        return t;
    }
}
