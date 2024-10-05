package grupo4.sprint6.controladores;

import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Controlador para manejar las operaciones relacionadas con la página de contacto.
 * Proporciona métodos para mostrar la página de contacto y manejar solicitudes.
 * 
 * @authors Ana Andrade, Carolina Díaz, Claudio Aranguiz, Lorena Suárez, Ricardo Ramones
 */
@Controller
public class ContactoController {

    /** Objeto {@link Logger} que contiene los métodos de depuración */
    private static final Logger logger = LogManager.getLogger(ContactoController.class);

    /**
     * Maneja las solicitudes GET para mostrar la página de contacto.
     * Agrega el rol del usuario autenticado al modelo para que esté disponible en la vista
     * @param nombre Opcional que puede contener el nombre del contacto.
     * @param request El objeto HttpServletRequest para obtener información de la solicitud.
     * @param modelo El objeto Model para pasar datos a la vista.
     * @return El nombre de la vista que se mostrará.
     */
    @GetMapping(path = "/contacto")
    public String paginaInicio(@PathVariable Optional<String> nombre, HttpServletRequest request, Model modelo) {
        // Depuración
        logger.info("Solicitud GET: {}", request.getRequestURI());
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String auth = authorities.toString();
        modelo.addAttribute("rol", auth);
        // Mostrar página
        return "contacto";
    }
}
