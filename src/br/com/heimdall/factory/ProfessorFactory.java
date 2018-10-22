package br.com.heimdall.factory;

import br.com.heimdall.model.Professor;

public class ProfessorFactory {
    public static Professor initialize() {
        Professor t = new Professor();
        t.setPessoa(PessoaFactory.initialize());
        return t;
    }
}
