package br.com.desafio.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="PROJETOS")
public class Projetos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false, length = 200)
    private String nome;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataInicio;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataPrevisaoFim;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataFim;

    @Column(columnDefinition = "LONGTEXT", nullable = false, length = 5000)
    private String descricao;

    @Column(nullable = false, length = 45)
    private String status;

    @Column(nullable = false)
    private float orcamento;

    @Column(nullable = false, length = 45)
    private String risco;


    @Column(name = "id_gerente")
    private Long idGerente;


}
