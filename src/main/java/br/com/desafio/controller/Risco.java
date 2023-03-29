package br.com.desafio.controller;

public enum Risco {
    BAIXO(1L),
    MEDIO(2L),

    ALTO(3L);

    private Long risco;

    Risco(Long risco) {
        this.risco = risco;
    }

    public Long getRisco() {
        return risco;
    }
}
