package br.com.nequesi.autenticacao.domain.usecase.role;

import br.com.nequesi.autenticacao.domain.entities.RoleHierarchy;
import br.com.nequesi.autenticacao.domain.repositories.RoleHierarchyRepository;
import br.com.nequesi.autenticacao.domain.usecase.UseCase;
import br.com.nequesi.autenticacao.domain.usecase.UseCaseExecutor;
import br.com.nequesi.autenticacao.domain.usecase.mapper.RoleHierarchyMapper;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ListRoleHierarchyByIdUseCase extends UseCase<ListRoleHierarchyByIdUseCase.InputValues,
        ListRoleHierarchyByIdUseCase.OutputValues> {

    @Autowired
    private RoleHierarchyRepository roleHierarchyRepository;

    @Autowired
    private UseCaseExecutor useCaseExecutor;

    @Autowired
    private RoleHierarchyMapper roleHierarchyMapper;

    @Override
    public OutputValues execute(InputValues input) {
        Optional<RoleHierarchy> optionalRoleHierarchy =
                roleHierarchyRepository.findById(input.getRoleHierarchyId());
        if (optionalRoleHierarchy.isPresent()) {
            return roleHierarchyMapper.toByIdOutputValues(optionalRoleHierarchy);
        }
        return null;
    }


    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class InputValues implements UseCase.InputValues {
        Long roleHierarchyId;
    }


    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class OutputValues implements UseCase.OutputValues {

        Long roleHierarchyId;
        String nome;
        String descricao;
    }
}
