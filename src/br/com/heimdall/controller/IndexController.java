package br.com.heimdall.controller;

import br.com.heimdall.application.Util;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class IndexController implements Serializable {

    public void redirect(String redirect) {
        Util.redirect(redirect);
    }

    public void login() {
        Util.redirect("login.xhtml");
    }

    public void mapa() {
        Util.redirect("mapa.xhtml");
    }
}
