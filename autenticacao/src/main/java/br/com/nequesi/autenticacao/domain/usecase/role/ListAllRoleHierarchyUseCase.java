package br.com.nequesi.autenticacao.domain.usecase.role;

import br.com.nequesi.autenticacao.domain.entities.RoleHierarchy;
import br.com.nequesi.autenticacao.domain.repositories.RoleHierarchyRepository;
import br.com.nequesi.autenticacao.domain.usecase.UseCase;
import br.com.nequesi.autenticacao.domain.usecase.UseCaseExecutor;
import br.com.nequesi.autenticacao.domain.usecase.mapper.RoleHierarchyMapper;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListAllRoleHierarchyUseCase extends UseCase<ListAllRoleHierarchyUseCase.InputValues,
        ListAllRoleHierarchyUseCase.OutputValuesList> {

    @Autowired
    private RoleHierarchyRepository roleHierarchyRepository;

    @Autowired
    private UseCaseExecutor useCaseExecutor;

    @Autowired
    private RoleHierarchyMapper roleHierarchyMapper;

    @Override
    public OutputValuesList execute(InputValues input) {

        List<RoleHierarchy> roleHierarchyList = roleHierarchyRepository.findAll();
        List<OutputValues> outputValuesList = roleHierarchyMapper.toOutputValuesList(roleHierarchyList);

        return OutputValuesList.builder()
                .outputValuesList(outputValuesList)
                .build();
    }

    @Builder
    @Data
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class InputValues implements UseCase.InputValues {

    }

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OutputValuesList implements UseCase.OutputValues {
        List<OutputValues> outputValuesList;
    }

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class OutputValues {

        Long roleHierarchyId;
        String nome;
        String descricao;
    }
}
