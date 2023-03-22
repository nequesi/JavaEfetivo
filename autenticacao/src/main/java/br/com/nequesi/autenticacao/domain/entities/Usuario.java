package br.com.nequesi.autenticacao.domain.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data @EqualsAndHashCode @Builder
@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Boolean ativo;

//    @Column(length = 75, nullable = false)
//    @Enumerated(EnumType.STRING)
//    private Role role;

    @ManyToMany
    @JoinTable(name = "usuario_papel",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "papel_id"))
    private List<Papel> papeis;
}
