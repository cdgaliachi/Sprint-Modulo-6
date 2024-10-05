package grupo4.sprint6.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import grupo4.sprint6.modelos.Capacitacion;

/**
 * Repositorio para la entidad {@code Capacitacion}.
 * Proporciona métodos de JPA para realizar operaciones de acceso a datos sobre {@code Capacitacion} en la base de datos.
 */
@Repository
public interface CapacitacionRepositorio extends JpaRepository<Capacitacion, Integer>{

}