package grupo4.sprint6.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import grupo4.sprint6.modelos.Visita;

/**
 * Repositorio para la entidad {@code Visita}.
 * Proporciona métodos de JPA para realizar operaciones de acceso a datos sobre {@code Visita} en la base de datos.
 */
@Repository
public interface VisitaRepositorio extends JpaRepository<Visita, Integer>{

}