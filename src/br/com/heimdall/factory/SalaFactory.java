package br.com.heimdall.factory;

import br.com.heimdall.model.Sala;

public class SalaFactory {
    public static Sala initialize() {
        Sala t = new Sala();
        return t;
    }
}
