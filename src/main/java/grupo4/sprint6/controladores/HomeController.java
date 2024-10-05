package grupo4.sprint6.controladores;

import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

/**
 * Controlador para manejar las solicitudes de la página de inicio.
 * 
 * @authors: Ana Andrade, Carolina Díaz, Claudio Aránguiz, Lorena Suárez, Ricardo Ramones
 */
@Controller
@RequestMapping(path = "/")
public class HomeController {

    // Constantes
    // -----------------------------------------------------------------------------------------

    /** Objeto {@link Logger} que contiene los métodos de depuración */
    private static final Logger logger = LogManager.getLogger(HomeController.class);

    // Solicitudes GET
    // -----------------------------------------------------------------------------------------

    /**
     * Muestra la Página de Inicio.
     *Agrega el rol del usuario autenticado al modelo para que esté disponible en la vista.
     * @param nombre  nombre de la persona (opcional)
     * @param request objeto {@link HttpServletRequest} que contiene la información
     *                de la solicitud que le hace el cliente al {@link HttpServlet}
     * @param modelo  objeto {@link Model} con el modelo de la vista
     *
     * @return un objeto {@link String} con la respuesta a la solicitud
     */
    @GetMapping(path = { "/", "/inicio" })
    public String paginaInicio(@PathVariable Optional<String> nombre, HttpServletRequest request, Model modelo) {
        // Depuración
        logger.info("Solicitud GET: {}", request.getRequestURI());
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String auth = authorities.toString();
        // Agrega el rol del usuario autenticado al modelo para que esté disponible en la vista
        modelo.addAttribute("rol", auth);
        // Mostrar página
        return "inicio";
    }
}
