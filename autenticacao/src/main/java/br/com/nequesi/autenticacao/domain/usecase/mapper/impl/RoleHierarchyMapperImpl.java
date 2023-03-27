package br.com.nequesi.autenticacao.domain.usecase.mapper.impl;

import br.com.nequesi.autenticacao.domain.entities.RoleHierarchy;
import br.com.nequesi.autenticacao.domain.usecase.mapper.RoleHierarchyMapper;
import br.com.nequesi.autenticacao.domain.usecase.role.CreateRoleHierarchyUseCase;
import br.com.nequesi.autenticacao.domain.usecase.role.ListRoleHierarchyByIdUseCase;
import br.com.nequesi.autenticacao.domain.usecase.role.ListAllRoleHierarchyUseCase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<ListAllRoleHierarchyUseCase.OutputValues> toOutputValuesList(List<RoleHierarchy> roleHierarchyList) {
        return roleHierarchyList.stream().map(roleHierarchy ->
            ListAllRoleHierarchyUseCase.OutputValues.builder()
                    .roleHierarchyId(roleHierarchy.getRoleHierarchyId())
                    .nome(roleHierarchy.getNome())
                    .descricao(roleHierarchy.getDescricao())
                    .build()
        ).collect(Collectors.toList());
    }

    @Override
    public ListRoleHierarchyByIdUseCase.OutputValues toByIdOutputValues(Optional<RoleHierarchy> optionalRoleHierarchy) {
        return ListRoleHierarchyByIdUseCase.OutputValues.builder()
                .roleHierarchyId(optionalRoleHierarchy.get().getRoleHierarchyId())
                .nome(optionalRoleHierarchy.get().getNome())
                .descricao(optionalRoleHierarchy.get().getDescricao())
                .build();
    }


}
