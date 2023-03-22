package br.com.nequesi.autenticacao.domain;

import br.com.nequesi.autenticacao.domain.entities.Condicao;
import br.com.nequesi.autenticacao.domain.entities.Usuario;

public class Validacao {

    public static Boolean verificarAutorizacao(Usuario usuario, Condicao condicao) {
        return Boolean.TRUE;
    }
}
