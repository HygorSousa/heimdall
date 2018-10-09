package br.com.heimdall.model;

import javax.persistence.*;

@Entity
public class Proposito extends DefaultEntity<Proposito> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idmatrizcurricular")
    private MatrizCurricular matrizCurricular;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public MatrizCurricular getMatrizCurricular() {
        return matrizCurricular;
    }

    public void setMatrizCurricular(MatrizCurricular matrizCurricular) {
        this.matrizCurricular = matrizCurricular;
    }
}
