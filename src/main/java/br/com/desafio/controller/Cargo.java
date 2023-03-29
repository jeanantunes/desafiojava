package br.com.desafio.controller;

public enum Cargo {
    FUNCIONARIO(1L),
    GERENTE(2L);

    private Long cargo;

    Cargo(Long cargo) {
        this.cargo = cargo;
    }

    public Long getCargo() {
        return cargo;
    }
}
