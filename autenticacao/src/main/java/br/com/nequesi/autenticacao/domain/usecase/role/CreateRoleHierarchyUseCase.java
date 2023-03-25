package br.com.nequesi.autenticacao.domain.usecase.role;

import br.com.nequesi.autenticacao.domain.repositories.RoleHierarchyRepository;
import br.com.nequesi.autenticacao.domain.usecase.UseCase;
import br.com.nequesi.autenticacao.domain.usecase.UseCaseExecutor;
import br.com.nequesi.autenticacao.domain.usecase.mapper.RoleHierarchyMapper;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Component
public class CreateRoleHierarchyUseCase extends UseCase<CreateRoleHierarchyUseCase.InputValues, CreateRoleHierarchyUseCase.OutputValues> {

    @Autowired
    private RoleHierarchyRepository roleHierarchyRepository;

    @Autowired
    private UseCaseExecutor useCaseExecutor;

    @Autowired
    private RoleHierarchyMapper roleHierarchyMapper;


    @Override
    public OutputValues execute(InputValues input) {

        return saveRole(input);
    }

    private OutputValues saveRole(InputValues input) {

        return roleHierarchyMapper.toOutputValues(
                roleHierarchyRepository.save(roleHierarchyMapper.toRole(input)));
    }


    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class InputValues implements UseCase.InputValues {

        String nome;
        String descricao;
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
