package br.com.heimdall.model;

import javax.persistence.*;

@Entity
public class Telefone extends DefaultEntity<Telefone> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer codigoArea;

    private String numero;

    @ManyToOne
    @JoinColumn(name = "idpessoa", nullable = false)
    private Pessoa pessoa;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(Integer codigoArea) {
        this.codigoArea = codigoArea;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}