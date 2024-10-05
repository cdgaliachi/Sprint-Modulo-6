package grupo4.sprint6.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import grupo4.sprint6.modelos.Profesional;


/**
 * Repositorio para la entidad {@code Profesional}.
 * Proporciona métodos de JPA para realizar operaciones de acceso a datos sobre {@code Profesional} en la base de datos.
 */
@Repository
public interface ProfesionalRepositorio extends JpaRepository<Profesional, Integer>{

}