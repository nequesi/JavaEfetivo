package br.com.nequesi.autenticacao.domain.entities;

import br.com.nequesi.autenticacao.domain.enuns.TipoOperacao;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_permissao")
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoOperacao tipo;

    @ManyToMany(mappedBy = "permissoes")
    private List<Papel> papeis;

    @ManyToOne
    private Recurso recurso;

    @Embedded
    private Condicao condicao;

    // getters e setters
}
