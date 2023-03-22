package br.com.nequesi.autenticacao.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_politica")
public class Politica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "papel_id")
    private Papel papel;

    @ManyToOne
    @JoinColumn(name = "permissao_id")
    private Permissao permissao;

    private String condicoes;

    // getters e setters
}
