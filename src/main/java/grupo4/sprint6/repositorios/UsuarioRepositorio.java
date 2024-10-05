package grupo4.sprint6.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import grupo4.sprint6.modelos.Usuario;

/**
 * Repositorio para la entidad {@code Usuario}.
 * Proporciona métodos de JPA para realizar operaciones de acceso a datos sobre {@code Usuario} en la base de datos.
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

}