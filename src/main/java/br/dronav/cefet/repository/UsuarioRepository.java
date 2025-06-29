package br.dronav.cefet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.dronav.cefet.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	/*@Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha")
    Usuario autenticar(@Param("email") String email, @Param("senha") String senha);*/
	Usuario findByEmail(String email);
}