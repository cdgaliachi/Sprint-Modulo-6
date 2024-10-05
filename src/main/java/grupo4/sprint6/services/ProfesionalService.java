package grupo4.sprint6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo4.sprint6.modelos.Profesional;
import grupo4.sprint6.modelos.Usuario;
import grupo4.sprint6.repositorios.ProfesionalRepositorio;
import grupo4.sprint6.repositorios.UsuarioRepositorio;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar operaciones relacionadas con la entidad {@code Profesional}.
 * Este servicio permite crear, obtener, actualizar y eliminar registros de profesionales en el sistema.
 * 
 * @author Ana Andrade
 * @author Carolina Diaz
 * @author Claudio Aranguiz
 * @author Lorena Suarez
 * @author Ricardo Ramones
 */
@Service
public class ProfesionalService {

    @Autowired
    ProfesionalRepositorio pRep; // Usamos "pRep" como variable del repositorio
    
    @Autowired
    UsuarioRepositorio uRep;

    /**
     * Crea o guarda un profesional en el sistema.
     * 
     * @param profesional El objeto {@code Profesional} a guardar.
     */
    public void saveProfesional(Profesional profesional) {
        pRep.save(profesional);
    }

    /**
     * Obtiene una lista de todos los profesionales en el sistema.
     * 
     * @return Una lista de objetos {@code Profesional}.
     */
    public List<Profesional> getAllProfesionales() {
        List<Profesional> listaProfesional = pRep.findAll();
        List<Usuario> listUsuario = uRep.findAll();
        
        if (!listaProfesional.isEmpty()) {
            for (Profesional pr : listaProfesional) {
                for (Usuario u : listUsuario) {
                    if (pr.getId() == u.getId()) {
                        pr.setId(u.getId());
                        pr.setNombre(u.getNombre());
                        pr.setRut(u.getRut());
                        pr.setTipo(u.getTipo());
                    }
                }
            }
        }
        return listaProfesional;
    }

    /**
     * Obtiene un profesional por su ID.
     * 
     * @param id El ID del profesional a buscar.
     * @return Un objeto {@code Optional} que contiene el {@code Profesional} si se encuentra, o vacío si no.
     */
    public Optional<Profesional> getProfesionalById(int id) {
        return pRep.findById(id);
    }

    /**
     * Actualiza un profesional existente en el sistema.
     * 
     * @param id El ID del profesional a actualizar.
     * @param detallesProfesional Un objeto {@code Profesional} que contiene los nuevos detalles a actualizar.
     * @return El objeto {@code Profesional} actualizado.
     * @throws RuntimeException si no se encuentra un profesional con el ID proporcionado.
     */
    public Profesional updateProfesional(int id, Profesional detallesProfesional) {
        Optional<Profesional> optionalProfesional = pRep.findById(id);

        if (optionalProfesional.isPresent()) {
            Profesional profesional = optionalProfesional.get();
            profesional.setTitulo(detallesProfesional.getTitulo());
            profesional.setFechaDeIngreso(detallesProfesional.getFechaDeIngreso());
            return pRep.save(profesional);
        } else {
            throw new RuntimeException("Profesional no encontrado con ID: " + id);
        }
    }

    /**
     * Elimina un profesional del sistema por su ID.
     * 
     * @param id El ID del profesional a eliminar.
     */
    public void deleteProfesional(int id) {
        pRep.deleteById(id);
    }
}
