package br.com.heimdall.model;

public enum DiaSemana implements DefaultEnum<DiaSemana> {
    SEGUNDA(1, "Segunda"),
    TERCA(2, "Terça"),
    QUARTA(3, "Quarta"),
    QUINTA(4, "Quinta"),
    SEXTA(5, "Sexta"),
    SABADO(6, "Sábado");

    private final Integer valor;
    private final String label;

    DiaSemana(Integer valorOpcao, String label) {
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