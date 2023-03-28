package br.com.desafio.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false, length = 200)
    private String nome;

    @Column(name = "pessoa_col", length = 45)
    private String pessoaCol;
}
