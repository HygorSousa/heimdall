package br.com.heimdall.factory;

import br.com.heimdall.model.Pessoa;

import java.util.ArrayList;

public class PessoaFactory {
    public static Pessoa initialize() {
        Pessoa t = new Pessoa();
        t.setUsuario(UsuarioFactory.initialize());
        t.setListaTelefone(new ArrayList<>());
        return t;
    }
}
