package grupo4.sprint6.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import grupo4.sprint6.modelos.Pago;

/**
 * Repositorio para la entidad {@code Pago}.
 * Proporciona métodos de JPA para realizar operaciones de acceso a datos sobre {@code Pago} en la base de datos.
 */
@Repository
public interface PagoRepositorio extends JpaRepository<Pago, Integer>{

}