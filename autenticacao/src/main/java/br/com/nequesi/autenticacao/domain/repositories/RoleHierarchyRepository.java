package br.com.nequesi.autenticacao.domain.repositories;

import br.com.nequesi.autenticacao.domain.entities.RoleHierarchy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleHierarchyRepository extends JpaRepository<RoleHierarchy, Long> {

}
