package br.com.heimdall.factory;

import br.com.heimdall.model.Proposito;

public class PropositoFactory {
    public static Proposito initialize() {
        Proposito t = new Proposito();
        t.setMatrizCurricular(MatrizCurricularFactory.initialize());
        return t;
    }
}
