package br.com.nequesi.autenticacao.presentation.controller.role;

import br.com.nequesi.autenticacao.domain.usecase.UseCaseExecutor;
import br.com.nequesi.autenticacao.domain.usecase.role.CreateRoleHierarchyUseCase;
import br.com.nequesi.autenticacao.presentation.controller.role.dto.RoleHierarchyRequest;
import br.com.nequesi.autenticacao.presentation.controller.role.dto.RoleHierarchyResponse;
import br.com.nequesi.autenticacao.presentation.mapper.RoleHierarchyControllerMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {

    private final UseCaseExecutor useCaseExecutor;
    private final CreateRoleHierarchyUseCase createRoleHierarchyUseCase;
    private final RoleHierarchyControllerMapper roleHierarchyControllerMapper;

    @PostMapping
    public RoleHierarchyResponse create(@RequestBody RoleHierarchyRequest roleHierarchyRequest) {

        return useCaseExecutor.execute(createRoleHierarchyUseCase,
                roleHierarchyControllerMapper.toCreateRole(roleHierarchyRequest),
                outputValues -> roleHierarchyControllerMapper.toRoleResponse(outputValues));
    }
}
