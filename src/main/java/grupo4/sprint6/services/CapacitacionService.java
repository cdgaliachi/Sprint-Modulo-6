package grupo4.sprint6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo4.sprint6.modelos.Capacitacion;
import grupo4.sprint6.repositorios.CapacitacionRepositorio;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar operaciones relacionadas con la entidad {@code Capacitacion}.
 * Este servicio permite crear, obtener, actualizar y eliminar registros de capacitaciones en el sistema.
 * 
 * @author Ana Andrade
 * @author Carolina Diaz
 * @author Claudio Aranguiz
 * @author Lorena Suarez
 * @author Ricardo Ramones
 */
@Service
public class CapacitacionService {

    @Autowired
    private CapacitacionRepositorio cRep; // Usamos "cRep" como variable del repositorio

    /**
     * Crea o guarda una capacitación en el sistema.
     * 
     * @param capacitacion El objeto {@code Capacitacion} a guardar.
     * @return El objeto {@code Capacitacion} guardado.
     */
    public Capacitacion saveCapacitacion(Capacitacion capacitacion) {
        return cRep.save(capacitacion);
    }

    /**
     * Obtiene una lista de todas las capacitaciones en el sistema.
     * 
     * @return Una lista de objetos {@code Capacitacion}.
     */
    public List<Capacitacion> getAllCapacitaciones() {
        return cRep.findAll();
    }

    /**
     * Obtiene una capacitación por su ID.
     * 
     * @param id El ID de la capacitación a buscar.
     * @return Un objeto {@code Optional} que contiene la {@code Capacitacion} si se encuentra, o vacío si no.
     */
    public Optional<Capacitacion> getCapacitacionById(int id) {
        return cRep.findById(id);
    }

    /**
     * Actualiza una capacitación existente en el sistema.
     * 
     * @param id El ID de la capacitación a actualizar.
     * @param detallesCapacitacion Un objeto {@code Capacitacion} que contiene los nuevos detalles a actualizar.
     * @return El objeto {@code Capacitacion} actualizado.
     * @throws RuntimeException si no se encuentra una capacitación con el ID proporcionado.
     */
    public Capacitacion updateCapacitacion(int id, Capacitacion detallesCapacitacion) {
        Optional<Capacitacion> optionalCapacitacion = cRep.findById(id);

        if (optionalCapacitacion.isPresent()) {
            Capacitacion capacitacion = optionalCapacitacion.get();
            capacitacion.setIdentificador(detallesCapacitacion.getIdentificador());
            capacitacion.setDia(detallesCapacitacion.getDia());
            capacitacion.setHora(detallesCapacitacion.getHora());
            capacitacion.setLugar(detallesCapacitacion.getLugar());
            capacitacion.setDuracion(detallesCapacitacion.getDuracion());
            capacitacion.setCantidadAsistentes(detallesCapacitacion.getCantidadAsistentes());
            return cRep.save(capacitacion);
        } else {
            throw new RuntimeException("Capacitación no encontrada con ID: " + id);
        }
    }

    /**
     * Elimina una capacitación del sistema por su ID.
     * 
     * @param id El ID de la capacitación a eliminar.
     */
    public void deleteCapacitacion(int id) {
        cRep.deleteById(id);
    }
}
