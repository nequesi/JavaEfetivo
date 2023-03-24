package br.com.nequesi.autenticacao.domain.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "tb_recurso")
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recursoId;

    private String nome;

    private String url;

    @OneToMany(mappedBy = "recurso", cascade = CascadeType.ALL)
    private List<Permissao> permissoes;
}
