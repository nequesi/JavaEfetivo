package br.com.nequesi.autenticacao.domain.entities;

import br.com.nequesi.autenticacao.domain.enuns.TipoOperacao;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_permissao")
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissaoId;

    @Embedded
    private Condicao condicao;

    @Enumerated(EnumType.STRING)
    private TipoOperacao tipo;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recurso_id")
    private Recurso recurso;

    @ManyToMany(mappedBy = "permissoes")
    private Set<Papel> papeis = new HashSet<>();

    // getters e setters
}
