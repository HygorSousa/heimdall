package br.com.heimdall.model;

import javax.persistence.*;

@Entity
public class Professor extends DefaultEntity<Professor> {

    @Id
    private Integer id;

    private String matricula;

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

    @Override
    public String toString() {
        if (this.matricula != null && this.getPessoa().getNome() != null)
            return this.matricula.concat(" - ").concat(this.getPessoa().getNome());
        return "";
    }
}
