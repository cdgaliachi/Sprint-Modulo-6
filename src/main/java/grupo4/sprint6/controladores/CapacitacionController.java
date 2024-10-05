package grupo4.sprint6.controladores;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import grupo4.sprint6.modelos.Capacitacion;
import grupo4.sprint6.services.CapacitacionService;

/**
 * Controlador para manejar las operaciones relacionadas con la entidad {@code Capacitacion}.
 * Proporciona métodos para listar, crear y gestionar capacitaciones.
 * 
 * @authors Ana Andrade, Carolina Díaz, Claudio Aranguiz, Lorena Suárez, Ricardo Ramones
 */
@Controller
@RequestMapping("/capacitaciones")
public class CapacitacionController {

    @Autowired
    CapacitacionService capacitacionService;

    /**
     * Maneja las solicitudes GET para listar todas las capacitaciones.
     * @return ModelAndView que muestra la lista de capacitaciones.
     */
    @GetMapping(path = "/listar")
    public ModelAndView listarCapacitacion() {
        List<Capacitacion> capacitaciones = capacitacionService.getAllCapacitaciones();
        ModelAndView modelo = new ModelAndView("listarCapacitacion", "capacitaciones", capacitaciones);
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String auth = authorities.toString();
        modelo.addObject("rol", auth);
        return modelo;
    }

    /**
     * Maneja las solicitudes GET para mostrar el formulario de creación de capacitaciones.
     * Agrega el rol del usuario autenticado al modelo para que esté disponible en la vista.
     * @return ModelAndView que muestra el formulario para crear una nueva capacitación.
     */
    @GetMapping(path = "/crear")
    public ModelAndView crearCapacitacion() {
        ModelAndView modelo = new ModelAndView("crearCapacitacion");
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String auth = authorities.toString();
        modelo.addObject("rol", auth);
        return modelo;
    }

    /**
     * Maneja las solicitudes POST para crear una nueva capacitación.
     * @param capacitacion Objeto {@code Capacitacion} que contiene la información a guardar.
     * @return Redirige a la lista de capacitaciones después de la creación.
     */
    @PostMapping(path = "/crear")
    public ModelAndView postCrearCapacitacion(@ModelAttribute Capacitacion capacitacion) {
        capacitacionService.saveCapacitacion(capacitacion);
        return new ModelAndView("redirect:/capacitaciones/listar");
    }
}
