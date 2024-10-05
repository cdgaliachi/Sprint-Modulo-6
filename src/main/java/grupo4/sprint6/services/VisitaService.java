package grupo4.sprint6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo4.sprint6.modelos.Visita;
import grupo4.sprint6.repositorios.VisitaRepositorio;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar operaciones relacionadas con la entidad {@code Visita}.
 * Este servicio permite crear, obtener, actualizar y eliminar registros de visitas en el sistema.
 * 
 * @author Ana Andrade
 * @author Carolina Diaz
 * @author Claudio Aranguiz
 * @author Lorena Suarez
 * @author Ricardo Ramones
 */
@Service
public class VisitaService {

    @Autowired
    private VisitaRepositorio vRep; // Repositorio de Visitas

    /**
     * Crea o guarda una visita en el sistema.
     * 
     * @param visita El objeto {@code Visita} a guardar.
     * @return El objeto {@code Visita} guardado.
     */
    public Visita saveVisita(Visita visita) {
        return vRep.save(visita);
    }

    /**
     * Obtiene una lista de todas las visitas en el sistema.
     * 
     * @return Una lista de objetos {@code Visita}.
     */
    public List<Visita> getAllVisitas() {
        return vRep.findAll();
    }

    /**
     * Obtiene una visita por su ID.
     * 
     * @param idV El ID de la visita a buscar.
     * @return Un objeto {@code Optional} que contiene la {@code Visita} si se encuentra, o vacío si no.
     */
    public Optional<Visita> getVisitaById(int idV) {
        return vRep.findById(idV);
    }

    /**
     * Actualiza una visita existente en el sistema.
     * 
     * @param idV El ID de la visita a actualizar.
     * @param detallesVisita Un objeto {@code Visita} que contiene los nuevos detalles a actualizar.
     * @throws RuntimeException si no se encuentra una visita con el ID proporcionado.
     */
    public Visita updateVisita(int idV, Visita detallesVisita) {
        Optional<Visita> optionalVisita = vRep.findById(idV);

        if (optionalVisita.isPresent()) {
            Visita visita = optionalVisita.get();
            visita.setId(detallesVisita.getId());
            visita.setFechaVisita(detallesVisita.getFechaVisita());
            return vRep.save(visita);
        } else {
            throw new RuntimeException("Visita no encontrada con ID: " + idV);
        }
    }

    /**
     * Elimina una visita del sistema por su ID.
     * 
     * @param idV El ID de la visita a eliminar.
     */
    public void deleteVisita(int idV) {
        vRep.deleteById(idV);
    }
}
