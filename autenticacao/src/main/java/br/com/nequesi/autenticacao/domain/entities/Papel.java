package br.com.nequesi.autenticacao.domain.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_papel")
public class Papel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @OneToMany(mappedBy = "papel", cascade = CascadeType.ALL)
    private List<Politica> politicas;

    @ManyToMany
    @JoinTable(name = "papel_permissao",
            joinColumns = @JoinColumn(name = "papel_id"),
            inverseJoinColumns = @JoinColumn(name = "permissao_id"))
    private List<Permissao> permissoes;

    @ManyToOne
    @JoinColumn(name = "papel_pai_id")
    private Papel papelPai;

    @OneToMany(mappedBy = "papelPai", cascade = CascadeType.ALL)
    private List<Papel> papeisFilhos;

    @ManyToOne
    @JoinColumn(name = "role_hierarchy_id")
    private RoleHierarchy roleHierarchy;

    // getters e setters
}
