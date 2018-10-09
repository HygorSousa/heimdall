package br.com.heimdall.model;

import javax.persistence.*;

@Entity
public class Responsavel extends DefaultEntity<Responsavel> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @MapsId("id")
    private Pessoa pessoa;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

}
