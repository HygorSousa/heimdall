package br.com.heimdall.model;

import javax.persistence.*;

@Entity
public class Curso extends DefaultEntity<Curso> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddisciplina", nullable = false)
    private Disciplina disciplina;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
