package br.com.nequesi.autenticacao.presentation.mapper.impl;

import br.com.nequesi.autenticacao.domain.usecase.role.CreateRoleHierarchyUseCase;
import br.com.nequesi.autenticacao.domain.usecase.role.ListAllRoleHierarchyUseCase;
import br.com.nequesi.autenticacao.domain.usecase.role.ListRoleHierarchyByIdUseCase;
import br.com.nequesi.autenticacao.presentation.controller.role.dto.RoleHierarchyRequest;
import br.com.nequesi.autenticacao.presentation.controller.role.dto.RoleHierarchyResponse;
import br.com.nequesi.autenticacao.presentation.mapper.RoleHierarchyControllerMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleHierarchyControllerControllerMapperImpl implements RoleHierarchyControllerMapper {

    @Override
    public CreateRoleHierarchyUseCase.InputValues toCreateRole(RoleHierarchyRequest roleHierarchyRequest) {
        return CreateRoleHierarchyUseCase.InputValues.builder()
                .nome(roleHierarchyRequest.getNome())
                .descricao(roleHierarchyRequest.getDescricao())
                .build();
    }

    @Override
    public RoleHierarchyResponse toRoleResponse(CreateRoleHierarchyUseCase.OutputValues outputValues) {
        return RoleHierarchyResponse.builder()
                .roleHierarchyId(outputValues.getRoleHierarchyId())
                .nome(outputValues.getNome())
                .descricao(outputValues.getDescricao())
                .build();
    }

    @Override
    public List<RoleHierarchyResponse> toListRoleResponse(ListAllRoleHierarchyUseCase.OutputValuesList outputValuesList) {
        return outputValuesList.getOutputValuesList().stream().map(outputValues ->
                RoleHierarchyResponse.builder()
                        .roleHierarchyId(outputValues.getRoleHierarchyId())
                        .nome(outputValues.getNome())
                        .descricao(outputValues.getDescricao())
                        .build()
                ).collect(Collectors.toList());
    }

    @Override
    public ListRoleHierarchyByIdUseCase.InputValues toListByIdInputValues(Long id) {
        return ListRoleHierarchyByIdUseCase.InputValues.builder().roleHierarchyId(id).build();
    }

    @Override
    public RoleHierarchyResponse getByIdRoleResponse(ListRoleHierarchyByIdUseCase.OutputValues outputValues) {
        return RoleHierarchyResponse.builder()
                .roleHierarchyId(outputValues.getRoleHierarchyId())
                .nome(outputValues.getNome())
                .descricao(outputValues.getDescricao())
                .build();
    }
}
