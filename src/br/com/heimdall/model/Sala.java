package br.com.heimdall.model;

import br.com.heimdall.application.Util;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sala extends DefaultEntity<Sala> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numeroSala;

    private String descricao;

    private Integer andar;

    private Integer bloco;

    private Integer tipoSala;

    private Integer statusSala;

    public Sala() {
    }

    public Sala(Integer numeroSala, String descricao, Integer andar, Integer bloco, Integer tipoSala, Integer statusSala) {
        this.numeroSala = numeroSala;
        this.descricao = descricao;
        this.andar = andar;
        this.bloco = bloco;
        this.tipoSala = tipoSala;
        this.statusSala = statusSala;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(Integer numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Andar getAndar() {
        return Util.parseEnum(this.andar, Andar.class);
    }

    public void setAndar(Andar andar) {
        this.andar = andar.valor;
    }

    public Bloco getBloco() {
        return Util.parseEnum(this.bloco, Bloco.class);
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco.valor;
    }

    public TipoSala getTipoSala() {
        return Util.parseEnum(this.tipoSala, TipoSala.class);
    }

    public void setTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala.valor;
    }

    public StatusSala getStatusSala() {
        return Util.parseEnum(this.statusSala, StatusSala.class);
    }

    public void setStatusSala(StatusSala statusSala) {
        this.statusSala = statusSala.valor;
    }

    public Andar[] getAndarValues() {
        return Andar.values();
    }

    public Bloco[] getBlocoValues() {
        return Bloco.values();
    }

    public TipoSala[] getTipoSalaValues() {
        return TipoSala.values();
    }

    public StatusSala[] getStatusSalaValues() {
        return StatusSala.values();
    }

    public enum Andar implements DefaultEnum<Andar> {
        TERREO(1, "Térreo"),
        PRIMEIROANDAR(2, "1º Andar");

        private final Integer valor;
        private final String label;

        Andar(Integer valorOpcao, String label) {
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

    public enum Bloco implements DefaultEnum<Bloco> {
        A(1, "Bloco A"),
        B(2, "Bloco B"),
        C(3, "Bloco C");

        private final Integer valor;
        private final String label;

        Bloco(Integer valorOpcao, String label) {
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

    public enum TipoSala implements DefaultEnum<TipoSala> {
        LABORATORIO(1, "Laboratório"),
        SALADEAULA(2, "Sala de Aula");

        private final Integer valor;
        private final String label;

        TipoSala(Integer valorOpcao, String label) {
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

    public enum StatusSala implements DefaultEnum<StatusSala> {
        DISPONIVEL(1, "Disponível"),
        INTERDITADA(2, "Interditada");

        private final Integer valor;
        private final String label;

        StatusSala(Integer valorOpcao, String label) {
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
