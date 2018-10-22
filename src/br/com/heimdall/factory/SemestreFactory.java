package br.com.heimdall.factory;

import br.com.heimdall.model.Semestre;

public class SemestreFactory {
    public static Semestre initialize() {
        Semestre t = new Semestre();
        return t;
    }
}
