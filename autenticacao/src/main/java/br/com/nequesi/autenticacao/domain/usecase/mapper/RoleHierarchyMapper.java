package br.com.nequesi.autenticacao.domain.usecase.mapper;

import br.com.nequesi.autenticacao.domain.entities.RoleHierarchy;
import br.com.nequesi.autenticacao.domain.usecase.role.CreateRoleHierarchyUseCase;
import br.com.nequesi.autenticacao.domain.usecase.role.ListRoleHierarchyByIdUseCase;
import br.com.nequesi.autenticacao.domain.usecase.role.ListAllRoleHierarchyUseCase;

import java.util.List;
import java.util.Optional;

public interface RoleHierarchyMapper {

    RoleHierarchy toRole(CreateRoleHierarchyUseCase.InputValues input);

    CreateRoleHierarchyUseCase.OutputValues toOutputValues(RoleHierarchy roleHierarchy);

    List<ListAllRoleHierarchyUseCase.OutputValues> toOutputValuesList(List<RoleHierarchy> roleHierarchyList);

    ListRoleHierarchyByIdUseCase.OutputValues toByIdOutputValues(Optional<RoleHierarchy> optionalRoleHierarchy);
}
