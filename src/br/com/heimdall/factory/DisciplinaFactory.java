package br.com.heimdall.factory;

import br.com.heimdall.model.Disciplina;

public class DisciplinaFactory {
    public static Disciplina initialize() {
        Disciplina t = new Disciplina();
        t.setCurso(CursoFactory.initialize());
        return t;
    }
}
