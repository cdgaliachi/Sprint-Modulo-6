package grupo4.sprint6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo4.sprint6.modelos.Usuario;
import grupo4.sprint6.modelos.Cliente;
import grupo4.sprint6.repositorios.ClienteRepositorio;
import grupo4.sprint6.repositorios.UsuarioRepositorio;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar operaciones relacionadas con la entidad {@code Cliente}.
 * Este servicio permite crear, obtener, actualizar y eliminar registros de clientes en el sistema.
 * 
 * @author Ana Andrade
 * @author Carolina Diaz
 * @author Claudio Aranguiz
 * @author Lorena Suarez
 * @author Ricardo Ramones
 */
@Service
public class ClienteService {

    @Autowired
    ClienteRepositorio cRep; // Usamos "cRep" como variable del repositorio
    
    @Autowired
    UsuarioRepositorio uRep;

    /**
     * Crea o guarda un cliente en el sistema.
     * 
     * @param cliente El objeto {@code Cliente} a guardar.
     */
    public void saveCliente(Cliente cliente) {
        cRep.save(cliente);
    }

    /**
     * Obtiene una lista de todos los clientes en el sistema.
     * 
     * @return Una lista de objetos {@code Cliente}.
     */
    public List<Cliente> getAllClientes() {
        List<Cliente> listCliente = cRep.findAll();
        List<Usuario> listUsuario = uRep.findAll();
        
        if (!listCliente.isEmpty()) {
            for (Cliente cl : listCliente) {
                for (Usuario u : listUsuario) {
                    if (cl.getId() == u.getId()) {
                        cl.setId(u.getId());
                        cl.setNombre(u.getNombre());
                        cl.setRut(u.getRut());
                        cl.setTipo(u.getTipo());
                    }
                }
            }
        }
        return listCliente;
    }

    /**
     * Obtiene un cliente por su ID.
     * 
     * @param id El ID del cliente a buscar.
     * @return Un objeto {@code Optional} que contiene el {@code Cliente} si se encuentra, o vacío si no.
     */
    public Optional<Cliente> getClienteById(int id) {
        return cRep.findById(id);
    }

    /**
     * Actualiza un cliente existente en el sistema.
     * 
     * @param id El ID del cliente a actualizar.
     * @param clienteDetalles Un objeto {@code Cliente} que contiene los nuevos detalles a actualizar.
     * @throws RuntimeException si no se encuentra un cliente con el ID proporcionado.
     */
    public void updateCliente(int id, Cliente clienteDetalles) {
        Optional<Cliente> optionalCliente = cRep.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            cliente.setNombre(clienteDetalles.getNombre());
            cliente.setRut(clienteDetalles.getRut());
            cliente.setTipo(clienteDetalles.getTipo());
            cliente.setTelefono(clienteDetalles.getTelefono());
            cliente.setComuna(clienteDetalles.getComuna());
            cRep.save(cliente);
        } else {
            throw new RuntimeException("Cliente no encontrado con ID: " + id);
        }
    }

    /**
     * Elimina un cliente del sistema por su ID.
     * 
     * @param id El ID del cliente a eliminar.
     */
    public void deleteCliente(int id) {
        cRep.deleteById(id);
    }
}
