package br.com.nequesi.autenticacao.presentation.mapper;

import br.com.nequesi.autenticacao.domain.usecase.role.CreateRoleHierarchyUseCase;
import br.com.nequesi.autenticacao.domain.usecase.role.ListAllRoleHierarchyUseCase;
import br.com.nequesi.autenticacao.domain.usecase.role.ListRoleHierarchyByIdUseCase;
import br.com.nequesi.autenticacao.presentation.controller.role.dto.RoleHierarchyRequest;
import br.com.nequesi.autenticacao.presentation.controller.role.dto.RoleHierarchyResponse;

import java.util.List;

public interface RoleHierarchyControllerMapper {

    CreateRoleHierarchyUseCase.InputValues toCreateRole(RoleHierarchyRequest roleHierarchyRequest);

    RoleHierarchyResponse toRoleResponse(CreateRoleHierarchyUseCase.OutputValues outputValues);

    List<RoleHierarchyResponse> toListRoleResponse(ListAllRoleHierarchyUseCase.OutputValuesList outputValues);

    ListRoleHierarchyByIdUseCase.InputValues toListByIdInputValues(Long id);

    RoleHierarchyResponse getByIdRoleResponse(ListRoleHierarchyByIdUseCase.OutputValues outputValues);
}
