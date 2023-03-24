package br.com.nequesi.autenticacao.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;
    private String nome;
    private String email;
    private String senha;
    private Boolean ativo;

    @ManyToMany
    @JoinTable(name = "usuario_papel",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "papel_id"))
    private List<Papel> papeis;

    public boolean temPapel(Papel papel) {

        for (Papel p : papeis) {
            if (p.getPapelPai() == papel) {
                return true;
            }
        }
        return false;
    }

    public boolean temPermissao(Permissao permissao) {

        return permissao.getPapeis() == papeis;
    }
}
