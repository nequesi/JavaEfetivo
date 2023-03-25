package br.com.nequesi.autenticacao.domain.usecase.mapper;

import br.com.nequesi.autenticacao.domain.entities.RoleHierarchy;
import br.com.nequesi.autenticacao.domain.usecase.role.CreateRoleHierarchyUseCase;

public interface RoleHierarchyMapper {

    RoleHierarchy toRole(CreateRoleHierarchyUseCase.InputValues input);

    CreateRoleHierarchyUseCase.OutputValues toOutputValues(RoleHierarchy roleHierarchy);
}
