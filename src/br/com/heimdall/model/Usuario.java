package br.com.heimdall.model;

import javax.persistence.*;

@Entity
public class Usuario extends DefaultEntity<Usuario> {

    @Id
    private Integer id;

    private String login;

    private String senha;

    @MapsId("id")
    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private Pessoa pessoa;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
