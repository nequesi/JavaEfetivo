package br.com.nequesi.autenticacao.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder @Data @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
@Entity @Table(name = "tb_politica")
public class Politica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long politicaId;

    private String nome;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "papel_id")
    private Papel papel;

    @ManyToOne
    @JoinColumn(name = "permissao_id")
    private Permissao permissao;


    /**
     * O método "autoriza" verifica se um usuário com determinado papel
     * possui a permissão requerida pela política;
     * @param papelUsuario
     * @param permissaoRequerida
     * @return
     */
    public boolean autorizaPermicaoPolitica(Papel papelUsuario, Permissao permissaoRequerida) {
        // Verifica se o papel do usuário possui a permissão requerida
        return papelUsuario.equals(papel) && permissaoRequerida.equals(permissao);
    }

    /**
     * Método "permiteAcesso" na classe Politica que verifica se um determinado usuário
     * tem permissão para acessar a política em questão, com base no modelo RBAC;
     * @param usuario método "permiteAcesso" na classe Politica que verifica se um determinado usuário
     * tem permissão para acessar a política em questão, com base no modelo RBAC;
     * @return Caso o usuário atenda a todas as condições, o método retorna "true",
     * permitindo que o acesso seja concedido. Caso contrário, retorna "false", impedindo o acesso.
     */
    public boolean permiteAcesso(Usuario usuario) {
        // Verifica se o usuário tem o papel necessário para acessar a política
        if (!usuario.temPapel(this.papel)) {
            return false;
        }

        // Verifica se o usuário tem a permissão necessária para acessar a política
        if (!usuario.temPermissao(this.permissao)) {
            return false;
        }


        // Se chegou aqui, o usuário tem o papel, a permissão e atende as condições adicionais
        return true;
    }
}
