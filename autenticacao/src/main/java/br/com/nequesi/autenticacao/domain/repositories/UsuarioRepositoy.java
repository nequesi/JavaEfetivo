package br.com.nequesi.autenticacao.domain.repositories;

import br.com.nequesi.autenticacao.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositoy extends JpaRepository<Usuario, Long> {
}
