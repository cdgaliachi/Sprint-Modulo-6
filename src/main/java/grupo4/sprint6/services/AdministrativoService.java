package grupo4.sprint6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo4.sprint6.modelos.Administrativo;
import grupo4.sprint6.modelos.Usuario;
import grupo4.sprint6.repositorios.AdministrativoRepositorio;
import grupo4.sprint6.repositorios.UsuarioRepositorio;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar operaciones relacionadas con la entidad {@code Administrativo}.
 * Este servicio permite crear, obtener, actualizar y eliminar registros de administrativos en el sistema.
 * 
 * @author Ana Andrade
 * @author Carolina Diaz
 * @author Claudio Aranguiz
 * @author Lorena Suarez
 * @author Ricardo Ramones
 */
@Service
public class AdministrativoService {

    @Autowired
    AdministrativoRepositorio aRep; // Usamos "aRep" como variable del repositorio

    @Autowired
    UsuarioRepositorio uRep;

    /**
     * Crea o guarda un administrativo en el sistema.
     * 
     * @param administrativo El objeto {@code Administrativo} a guardar.
     */
    public void saveAdministrativo(Administrativo administrativo) {
        aRep.save(administrativo);
    }

    /**
     * Obtiene una lista de todos los administrativos en el sistema.
     * 
     * @return Una lista de objetos {@code Administrativo}.
     */
    public List<Administrativo> getAllAdministrativos() {
        List<Administrativo> listAdministrativo = aRep.findAll();
        List<Usuario> listUsuario = uRep.findAll();
        
        if (!listAdministrativo.isEmpty()) {
            for (Administrativo a : listAdministrativo) {
                for (Usuario u : listUsuario) {
                    if (a.getId() == u.getId()) {
                        a.setId(u.getId());
                        a.setNombre(u.getNombre());
                        a.setRut(u.getRut());
                        a.setTipo(u.getTipo());
                    }
                }
            }
        }
        return listAdministrativo;
    }

    /**
     * Obtiene un administrativo por su ID.
     * 
     * @param id El ID del administrativo a buscar.
     * @return Un objeto {@code Optional} que contiene el {@code Administrativo} si se encuentra, o vacío si no.
     */
    public Optional<Administrativo> getAdministrativoById(int id) {
        return aRep.findById(id);
    }

    /**
     * Actualiza un administrativo existente en el sistema.
     * 
     * @param id El ID del administrativo a actualizar.
     * @param adminDetalles Un objeto {@code Administrativo} que contiene los nuevos detalles a actualizar.
     * @throws RuntimeException si no se encuentra un administrativo con el ID proporcionado.
     */
    public void updateAdministrativo(int id, Administrativo adminDetalles) {
        Optional<Administrativo> optionalAdmin = aRep.findById(id);

        if (optionalAdmin.isPresent()) {
            Administrativo administrativo = optionalAdmin.get();
            administrativo.setNombre(adminDetalles.getNombre());
            administrativo.setRut(adminDetalles.getRut());
            administrativo.setTipo(adminDetalles.getTipo());
            administrativo.setArea(adminDetalles.getArea());
            administrativo.setExperienciaPrevia(adminDetalles.getExperienciaPrevia());
            aRep.save(administrativo);
        } else {
            throw new RuntimeException("Administrativo no encontrado con ID: " + id);
        }
    }

    /**
     * Elimina un administrativo del sistema por su ID.
     * 
     * @param id El ID del administrativo a eliminar.
     */
    public void deleteAdministrativo(int id) {
        aRep.deleteById(id);
    }
}
