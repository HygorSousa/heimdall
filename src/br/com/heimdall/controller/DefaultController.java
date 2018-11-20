package br.com.heimdall.controller;

import br.com.heimdall.application.Session;
import br.com.heimdall.model.Usuario;

import java.io.Serializable;


public class DefaultController implements Serializable {

    private static final long serialVersionUID = 1007297527954376818L;

    private static final String userKey = "usuarioLogado";

    public Usuario getUsuarioLogado() {
        return (Usuario) Session.getInstance().getAttribute(userKey);
    }

    public void setUsuarioLogado(Usuario usuario) {
        Session.getInstance().setAttribute(userKey, usuario);
    }

    public void encerrarSessao() {
        Session.getInstance().invalidateSession();
    }

}