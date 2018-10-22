package br.com.heimdall.factory;

import br.com.heimdall.model.Lotacao;

public class LotacaoFactory {
    public static Lotacao initialize() {
        Lotacao t = new Lotacao();
        t.setProposito(PropositoFactory.initialize());
        t.setResponsavel(ResponsavelFactory.initialize());
        t.setSala(SalaFactory.initialize());
        return t;
    }
}
