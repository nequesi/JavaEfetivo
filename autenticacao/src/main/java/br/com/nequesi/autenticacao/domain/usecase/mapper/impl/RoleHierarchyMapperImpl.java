package br.com.nequesi.autenticacao.domain.usecase.mapper.impl;

import br.com.nequesi.autenticacao.domain.entities.RoleHierarchy;
import br.com.nequesi.autenticacao.domain.usecase.mapper.RoleHierarchyMapper;
import br.com.nequesi.autenticacao.domain.usecase.role.CreateRoleHierarchyUseCase;
import org.springframework.stereotype.Component;

@Component
public class RoleHierarchyMapperImpl implements RoleHierarchyMapper {
    @Override
    public RoleHierarchy toRole(CreateRoleHierarchyUseCase.InputValues input) {
        return RoleHierarchy.builder()
                .nome(input.getNome())
                .descricao(input.getDescricao())
                .build();
    }

    @Override
    public CreateRoleHierarchyUseCase.OutputValues toOutputValues(RoleHierarchy roleHierarchy) {
        return CreateRoleHierarchyUseCase.OutputValues.builder()
                .roleHierarchyId(roleHierarchy.getRoleHierarchyId())
                .nome(roleHierarchy.getNome())
                .descricao(roleHierarchy.getDescricao())
                .build();
    }
}
