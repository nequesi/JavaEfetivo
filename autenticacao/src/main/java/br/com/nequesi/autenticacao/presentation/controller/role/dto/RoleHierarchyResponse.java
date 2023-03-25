package br.com.nequesi.autenticacao.presentation.controller.role.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleHierarchyResponse {
    private Long roleHierarchyId;
    private String nome;
    private String descricao;
}
