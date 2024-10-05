package grupo4.sprint6.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlador para manejar las sesiones de usuario, incluyendo login y logout.
 * 
 * @authors: Ana Andrade, Carolina Díaz, Claudio Aránguiz, Lorena Suárez, Ricardo Ramones
 */
@Controller
public class SesionController {
    
    // Constantes
    // -----------------------------------------------------------------------------------------
    /** Objeto {@link Logger} que contiene los métodos de depuración */
    private static final Logger logger = LogManager.getLogger(SesionController.class);
    
    // Solicitud GET para login
    // -----------------------------------------------------------------------------------------
    /**
     * Muestra la página de login.
     *
     * @param request objeto {@link HttpServletRequest} que contiene la información
     *                de la solicitud que le hace el cliente al {@link HttpServlet}
     * @return un objeto {@link ModelAndView} con la vista de login
     */
    @GetMapping(path = "/login")
    public ModelAndView logInPage(HttpServletRequest request) {
        // Depuración
        logger.info("Solicitud GET para login: {}", request.getRequestURI());
        
        return new ModelAndView("login");
    }
    
    // Solicitud GET para logout
    // -----------------------------------------------------------------------------------------
    /**
     * Maneja el proceso de logout.
     *
     * @param request objeto {@link HttpServletRequest} que contiene la información
     *                de la solicitud que le hace el cliente al {@link HttpServlet}
     * @return una redirección a la página principal
     */
    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) {
        // Depuración
        logger.info("Solicitud GET para logout: {}", request.getRequestURI());
        
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            logger.info("Sesión invalidada");
        }
        
        // Redirigir a la página principal después del logout
        return "redirect:/";
    }
    
    // Nuevo método para manejar el acceso denegado
    // -----------------------------------------------------------------------------------------
    /**
     * Muestra la página de acceso denegado.
     *
     * @param request objeto {@link HttpServletRequest} que contiene la información
     *                de la solicitud que le hace el cliente al {@link HttpServlet}
     * @return un objeto {@link ModelAndView} con la vista de acceso denegado
     */
    @GetMapping("/acceso-denegado")
    public ModelAndView accessDenied(HttpServletRequest request) {
        logger.info("Acceso denegado para la solicitud: {}", request.getRequestURI());
        ModelAndView mav = new ModelAndView("acceso-denegado");
        mav.addObject("mensaje", "Lo sentimos, no tienes permiso para acceder a esta página.");
        return mav;
    }
    
    // Método para manejar errores de login
    // -----------------------------------------------------------------------------------------
    /**
     * Muestra un mensaje de error en el intento de login.
     *
     * @param request objeto {@link HttpServletRequest} que contiene la información
     *                de la solicitud que le hace el cliente al {@link HttpServlet}
     * @return un objeto {@link ModelAndView} con la vista de login y el mensaje de error
     */
    @GetMapping("/login-error")
    public ModelAndView loginError(HttpServletRequest request) {
        logger.info("Error en el intento de login");
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("error", "Credenciales inválidas");
        return mav;
    }
}
