package grupo4.sprint6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo4.sprint6.modelos.Pago;
import grupo4.sprint6.repositorios.PagoRepositorio;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar operaciones relacionadas con la entidad {@code Pago}.
 * Este servicio permite crear, obtener, actualizar y eliminar registros de pagos en el sistema.
 * 
 * @author Ana Andrade
 * @author Carolina Diaz
 * @author Claudio Aranguiz
 * @author Lorena Suarez
 * @author Ricardo Ramones
 */
@Service
public class PagoService {

    @Autowired
    private PagoRepositorio paRep; // Repositorio de Pago

    /**
     * Crea o guarda un pago en el sistema.
     * 
     * @param pago El objeto {@code Pago} a guardar.
     * @return El objeto {@code Pago} guardado.
     */
    public Pago savePagos(Pago pago) {
        return paRep.save(pago);
    }

    /**
     * Obtiene una lista de todos los pagos en el sistema.
     * 
     * @return Una lista de objetos {@code Pago}.
     */
    public List<Pago> getAllPagos() {
        return paRep.findAll();
    }

    /**
     * Obtiene un pago por su ID.
     * 
     * @param idP El ID del pago a buscar.
     * @return Un objeto {@code Optional} que contiene el {@code Pago} si se encuentra, o vacío si no.
     */
    public Optional<Pago> getPagoById(int idP) {
        return paRep.findById(idP);
    }

    /**
     * Actualiza un pago existente en el sistema.
     * 
     * @param idP El ID del pago a actualizar.
     * @param detallesPagos Un objeto {@code Pago} que contiene los nuevos detalles a actualizar.
     * @return El objeto {@code Pago} actualizado.
     * @throws RuntimeException si no se encuentra un pago con el ID proporcionado.
     */
    public Pago updatePagos(int idP, Pago detallesPagos) {
        Optional<Pago> optionalPagos = paRep.findById(idP);

        if (optionalPagos.isPresent()) {
            Pago pago = optionalPagos.get();
            pago.setId(detallesPagos.getId());
            pago.setMonto(detallesPagos.getMonto());
            return paRep.save(pago);
        } else {
            throw new RuntimeException("Pago no encontrado con ID: " + idP);
        }
    }

    /**
     * Elimina un pago del sistema por su ID.
     * 
     * @param idP El ID del pago a eliminar.
     */
    public void deletePagos(int idP) {
        paRep.deleteById(idP);
    }
}
