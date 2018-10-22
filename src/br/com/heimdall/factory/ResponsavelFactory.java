package br.com.heimdall.factory;

import br.com.heimdall.model.Responsavel;

public class ResponsavelFactory {
    public static Responsavel initialize() {
        Responsavel t = new Responsavel();
        t.setPessoa(PessoaFactory.initialize());
        return t;
    }
}
