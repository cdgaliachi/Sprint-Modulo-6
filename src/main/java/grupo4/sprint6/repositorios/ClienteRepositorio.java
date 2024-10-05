package grupo4.sprint6.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import grupo4.sprint6.modelos.Cliente;

/**
 * Repositorio para la entidad {@code Cliente}.
 * Proporciona métodos de JPA para realizar operaciones de acceso a datos sobre {@code Cliente} en la base de datos.
 */
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

}