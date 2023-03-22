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

    @Embedded
    private Condicao condicao;

    @Enumerated(EnumType.STRING)
    private TipoOperacao tipo;

    @ManyToOne
    private Recurso recurso;

    @ManyToMany(mappedBy = "permissoes")
    private List<Papel> papeis;

    // getters e setters
}
