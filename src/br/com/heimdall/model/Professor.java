package br.com.heimdall.model;

import javax.persistence.*;

@Entity
public class Professor extends DefaultEntity<Professor> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String matricula;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idpessoa")
    private Pessoa pessoa;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
