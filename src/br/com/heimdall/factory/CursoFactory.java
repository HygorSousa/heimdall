package br.com.heimdall.factory;

import br.com.heimdall.model.Curso;

public class CursoFactory {
    public static Curso initialize() {
        Curso t = new Curso();
        return t;
    }
}
