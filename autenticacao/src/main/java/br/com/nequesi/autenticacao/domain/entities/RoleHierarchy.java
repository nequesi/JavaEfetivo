package br.com.nequesi.autenticacao.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity @Table(name = "tb_hierarquia_role")
public class RoleHierarchy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleHierarchyId;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "roleHierarchy", cascade = CascadeType.ALL)
    private List<Papel> papeis;

    @ManyToOne
    @JoinColumn(name = "role_hierarchy_pai_id")
    private RoleHierarchy roleHierarchyPai;

    @OneToMany(mappedBy = "roleHierarchyPai", cascade = CascadeType.ALL)
    private List<RoleHierarchy> roleHierarchiesFilhas;

    // getters e setters
}
