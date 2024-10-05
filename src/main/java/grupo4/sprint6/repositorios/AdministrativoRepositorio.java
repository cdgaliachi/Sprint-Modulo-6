package grupo4.sprint6.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import grupo4.sprint6.modelos.Administrativo;

/**
 * Repositorio para la entidad {@code Administrativo}.
 * Proporciona métodos de JPA para realizar operaciones de acceso a datos sobre {@code Administrativo} en la base de datos.
 */

@Repository
public interface AdministrativoRepositorio extends JpaRepository<Administrativo, Integer>{

}