package br.com.desafio.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="MEMBROS")
public class Membros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "projetos_id", foreignKey=@ForeignKey(name = "fk_membros_projetos_idx"))
    private Projetos projetosId;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", foreignKey=@ForeignKey(name = "fk_membros_pessoa1_idx"))
    private Pessoa pessoaId;
}
