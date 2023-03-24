package br.com.nequesi.autenticacao.domain.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

@Builder
@Data

@EqualsAndHashCode
@Embeddable
public class Condicao {

    private String campo;
    private String operador;
    private String valor;

    public Condicao() {}

    public Condicao(String campo, String operador, String valor) {
        this.campo = campo;
        this.operador = operador;
        this.valor = valor;
    }

    // getters e setters
}

