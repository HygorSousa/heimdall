package br.com.heimdall.model;

import javax.persistence.*;

@Entity
public class MatrizCurricular extends DefaultEntity<MatrizCurricular> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantidadeHoras;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idcurso")
    private Curso curso;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iddisciplina")
    private Disciplina disciplina;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idprofessor")
    private Professor professor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idsemestre")
    private Semestre semestre;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(Integer quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }
}
