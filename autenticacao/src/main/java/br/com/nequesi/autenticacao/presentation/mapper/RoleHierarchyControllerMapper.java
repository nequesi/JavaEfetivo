package br.com.nequesi.autenticacao.presentation.mapper;

import br.com.nequesi.autenticacao.domain.usecase.role.CreateRoleHierarchyUseCase;
import br.com.nequesi.autenticacao.presentation.controller.role.dto.RoleHierarchyRequest;
import br.com.nequesi.autenticacao.presentation.controller.role.dto.RoleHierarchyResponse;

public interface RoleHierarchyControllerMapper {

    CreateRoleHierarchyUseCase.InputValues toCreateRole(RoleHierarchyRequest roleHierarchyRequest);

    RoleHierarchyResponse toRoleResponse(CreateRoleHierarchyUseCase.OutputValues outputValues);
}
