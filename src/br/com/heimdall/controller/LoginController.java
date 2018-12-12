package br.com.heimdall.controller;

import br.com.heimdall.application.Util;
import br.com.heimdall.factory.JPAFactory;
import br.com.heimdall.factory.UsuarioFactory;
import br.com.heimdall.model.Usuario;
import br.com.heimdall.repository.UsuarioRepository;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class LoginController extends DefaultController {

    private Usuario usuario;

    public void entrar() {
        UsuarioRepository repository = new UsuarioRepository(JPAFactory.getEntityManager());
        Usuario usuarioValidado = repository.buscarUsuarioLogar(getUsuario().getLogin(), getUsuario().getSenha());

        if (usuarioValidado == null) {
            Util.addErroMessage("Usuário ou Senha inválido.");
            return;
        }
        setUsuarioLogado(usuarioValidado);

        Util.redirect("pages/lotacao.xhtml");
    }

    public Usuario getUsuario() {
        if (usuario == null)
            usuario = UsuarioFactory.initialize();
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
