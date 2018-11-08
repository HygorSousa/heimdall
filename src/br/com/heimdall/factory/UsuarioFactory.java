package br.com.heimdall.factory;

import br.com.heimdall.model.Usuario;

public class UsuarioFactory {
    public static Usuario initialize() {
        Usuario t = new Usuario();
        return t;
    }
}
