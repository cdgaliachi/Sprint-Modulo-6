package grupo4.sprint6.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import grupo4.sprint6.modelos.Usuario;
import grupo4.sprint6.modelos.Visita;
import grupo4.sprint6.services.UsuarioService;
import grupo4.sprint6.services.VisitaService;

/**
 * Controlador para manejar las visitas realizadas a un cliente.
 * 
 * @authors: Ana Andrade, Carolina Díaz, Claudio Aránguiz, Lorena Suárez, Ricardo Ramones
 */
@Controller
public class VisitaController {
	
	@Autowired
	VisitaService visitaService;
	
	@Autowired
	UsuarioService usuarioService;
	
	// Solicitud GET para listar visitas
	// -----------------------------------------------------------------------------------------
	/**
	 * Lista todas las visitas y muestra la vista correspondiente.
	 *
	 * @return un objeto {@link ModelAndView} con la vista de listado de visitas
	 */
	@GetMapping(path = "/visitas")
	public ModelAndView listarVisitas() {
		List<Visita> listaVisitas = visitaService.getAllVisitas();
		List<Usuario> listaUsuarios = usuarioService.getAllUsuarios();
		List<String> listaRut = new ArrayList<>();
		for (Visita v : listaVisitas) {
			for (Usuario u : listaUsuarios) {
				if (v.getId() == u.getId()){
					listaRut.add(u.getRut());
				}
			}
		}
		ModelAndView modelo = new ModelAndView("listadoDeVisitas", "visitas", listaVisitas);
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String auth = authorities.toString();
        modelo.addObject("rol", auth);
        modelo.addObject("rut", listaRut);
        modelo.addObject("usuarios", listaUsuarios);
        return modelo;
	}
	
	// Solicitud GET para mostrar checklist
	// -----------------------------------------------------------------------------------------
	/**
	 * Muestra la vista del checklist.
	 *
	 * @param model objeto {@link Model} que contiene los atributos del modelo
	 * @return la vista de responder checklist
	 */
	@GetMapping(path = "/checklist")
	public String mostrarChecklist(Model model) {
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String auth = authorities.toString();
        model.addAttribute("rol", auth);
		return "responderChecklist";
	}
	
	// Solicitud POST para crear visita
	// -----------------------------------------------------------------------------------------
	/**
	 * Crea una nueva visita.
	 *
	 * @param visita objeto {@link Visita} que contiene la información de la visita
	 * @return una redirección a la lista de visitas
	 */
	@PostMapping(path = "/visitas")
	public String crearVista(@ModelAttribute Visita visita) {
		Visita newVisita = visita;
		String fechaVisita = visita.getFechaVisita();
		String[] fechaArray = fechaVisita.split("-");
		String fechaOrdenada = fechaArray[2] + "-" + fechaArray[1] + "-" + fechaArray[0];
		newVisita.setFechaVisita(fechaOrdenada);
		visitaService.saveVisita(newVisita);
		return "redirect:/visitas";
	}
}
