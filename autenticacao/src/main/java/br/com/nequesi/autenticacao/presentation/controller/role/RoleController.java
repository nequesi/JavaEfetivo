package br.com.nequesi.autenticacao.presentation.controller.role;

import br.com.nequesi.autenticacao.domain.usecase.UseCaseExecutor;
import br.com.nequesi.autenticacao.domain.usecase.role.CreateRoleHierarchyUseCase;
import br.com.nequesi.autenticacao.domain.usecase.role.ListAllRoleHierarchyUseCase;
import br.com.nequesi.autenticacao.domain.usecase.role.ListRoleHierarchyByIdUseCase;
import br.com.nequesi.autenticacao.presentation.controller.role.dto.RoleHierarchyRequest;
import br.com.nequesi.autenticacao.presentation.controller.role.dto.RoleHierarchyResponse;
import br.com.nequesi.autenticacao.presentation.mapper.RoleHierarchyControllerMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {

    private final UseCaseExecutor useCaseExecutor;
    private final CreateRoleHierarchyUseCase createRoleHierarchyUseCase;
    private final ListAllRoleHierarchyUseCase listAllRoleHierarchyUseCase;
    private final ListRoleHierarchyByIdUseCase getByIdRoleHierarchyUseCase;
    private final RoleHierarchyControllerMapper roleHierarchyControllerMapper;

    @PostMapping
    public RoleHierarchyResponse create(@RequestBody RoleHierarchyRequest roleHierarchyRequest) {

        return useCaseExecutor.execute(createRoleHierarchyUseCase,
                roleHierarchyControllerMapper.toCreateRole(roleHierarchyRequest),
                outputValues -> roleHierarchyControllerMapper.toRoleResponse(outputValues));
    }

    @GetMapping("/{id}")
    public RoleHierarchyResponse getById(@PathVariable(name = "id") Long id) {

        return useCaseExecutor.execute(getByIdRoleHierarchyUseCase,
                roleHierarchyControllerMapper.toListByIdInputValues(id),
                outputValues -> roleHierarchyControllerMapper.getByIdRoleResponse(outputValues));
    }

    @GetMapping
    public List<RoleHierarchyResponse> listAll() {

        return useCaseExecutor.execute(listAllRoleHierarchyUseCase,
                null,
                outputValuesList -> roleHierarchyControllerMapper.toListRoleResponse(outputValuesList));
    }
}
