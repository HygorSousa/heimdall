package br.com.heimdall.model;

import br.com.heimdall.application.Util;

import javax.persistence.*;

@Entity
public class Proposito extends DefaultEntity<Proposito> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    private Integer tipoProposito;

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

    public TipoProposito getTipoProposito() {
        return Util.parseEnum(this.tipoProposito, TipoProposito.class);
    }

    public void setTipoProposito(TipoProposito tipoProposito) {
        this.tipoProposito = tipoProposito.valor;
    }

    public TipoProposito[] getTipoPropositoValues() {
        return TipoProposito.values();
    }

    public enum TipoProposito implements DefaultEnum<TipoProposito> {
        AULA(1, "Aula"),
        EVENTO(2, "Evento"),
        MANUTENCAO(3, "Manutenção"),
        MONITORIA(4, "Monitoria");

        private final Integer valor;
        private final String label;

        TipoProposito(Integer valorOpcao, String label) {
            this.valor = valorOpcao;
            this.label = label;
        }

        public Integer getValor() {
            return valor;
        }

        public String getLabel() {
            return label;
        }

        @Override
        public String toString() {
            return Integer.toString(this.valor);
        }
    }

}
