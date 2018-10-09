package br.com.heimdall.model;

import br.com.heimdall.application.Util;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Semestre extends DefaultEntity<Semestre> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer ano;

    private Boolean ativo;

    private Integer tipoSemestre;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public TipoSemestre getTipoSemestre() {
        return Util.parseEnum(this.tipoSemestre, TipoSemestre.class);
    }

    public void setTipoSemestre(TipoSemestre tipoSemestre) {
        this.tipoSemestre = tipoSemestre.valor;
    }

    public TipoSemestre[] getTipoSemestreValues() {
        return TipoSemestre.values();
    }

    public enum TipoSemestre implements DefaultEnum<TipoSemestre> {
        PRIMEIROSEMESTRE(1, "1º Semestre"),
        SEGUNDOSEMESTRE(2, "2º Semestre");

        private final Integer valor;
        private final String label;

        TipoSemestre(Integer valorOpcao, String label) {
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
