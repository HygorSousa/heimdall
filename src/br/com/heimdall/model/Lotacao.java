package br.com.heimdall.model;

import br.com.heimdall.application.Util;

import javax.persistence.*;
import java.util.Date;

@Entity
public class
Lotacao extends DefaultEntity<Lotacao> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(value = TemporalType.DATE)
    private Date dataEntrada;

    @Temporal(value = TemporalType.DATE)
    private Date dataSaida;

    @Temporal(value = TemporalType.TIME)
    private Date horarioInicio;

    private Double quantidadeHoras;

    private Integer diaSemana;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idproposito")
    private Proposito proposito;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idresponsavel")
    private Responsavel responsavel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idsala")
    private Sala sala;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Date getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Date horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Double getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(Double quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }

    public DiaSemana getDiaSemana() {
        return Util.parseEnum(diaSemana, DiaSemana.class);
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana.getValor();
    }

    public Proposito getProposito() {
        return proposito;
    }

    public void setProposito(Proposito proposito) {
        this.proposito = proposito;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public DiaSemana[] getDiaSemanaValues() {
        return DiaSemana.values();
    }
}
