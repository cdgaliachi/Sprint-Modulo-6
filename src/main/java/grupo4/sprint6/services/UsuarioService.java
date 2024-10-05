package grupo4.sprint6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo4.sprint6.modelos.Usuario;
import grupo4.sprint6.repositorios.UsuarioRepositorio;

/**
 * Servicio para gestionar operaciones relacionadas con la entidad {@code Usuario}.
 * Este servicio permite crear, obtener, actualizar y eliminar registros de usuarios en el sistema.
 * 
 * @author Ana Andrade
 * @author Carolina Diaz
 * @author Claudio Aranguiz
 * @author Lorena Suarez
 * @author Ricardo Ramones
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositorio uRep; // Usamos "uRep" como variable del repositorio

    /**
     * Crea o guarda un usuario en el sistema.
     * 
     * @param usuario El objeto {@code Usuario} a guardar.
     * @return El objeto {@code Usuario} guardado.
     */
    public Usuario saveUsuario(Usuario usuario) {
        return uRep.save(usuario);
    }

    /**
     * Obtiene una lista de todos los usuarios en el sistema.
     * 
     * @return Una lista de objetos {@code Usuario}.
     */
    public List<Usuario> getAllUsuarios() {
        return uRep.findAll();
    }

    /**
     * Obtiene un usuario por su ID.
     * 
     * @param id El ID del usuario a buscar.
     * @return Un objeto {@code Optional} que contiene el {@code Usuario} si se encuentra, o vacío si no.
     */
    public Optional<Usuario> getUsuarioById(int id) {
        return uRep.findById(id);
    }

    /**
     * Actualiza un usuario existente en el sistema.
     * 
     * @param id El ID del usuario a actualizar.
     * @param usuarioDetalles Un objeto {@code Usuario} que contiene los nuevos detalles a actualizar.
     * @throws RuntimeException si no se encuentra un usuario con el ID proporcionado.
     */
    public void updateUsuario(int id, Usuario usuarioDetalles) {
        Optional<Usuario> optionalUsuario = uRep.findById(id);

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setNombre(usuarioDetalles.getNombre());
            usuario.setRut(usuarioDetalles.getRut());
            usuario.setTipo(usuarioDetalles.getTipo());
            uRep.save(usuario);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }

    /**
     * Elimina un usuario del sistema por su ID.
     * 
     * @param id El ID del usuario a eliminar.
     */
    public void deleteUsuario(int id) {
        uRep.deleteById(id);
    }
}
