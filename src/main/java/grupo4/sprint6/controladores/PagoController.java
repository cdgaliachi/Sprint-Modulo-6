package grupo4.sprint6.controladores;

import java.util.ArrayList;
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

import grupo4.sprint6.modelos.Pago;
import grupo4.sprint6.modelos.Usuario;
import grupo4.sprint6.services.PagoService;
import grupo4.sprint6.services.UsuarioService;

/**
 * Controlador para manejar las solicitudes relacionadas con los pagos.
 * 
 * @authors: Ana Andrade, Carolina Díaz, Claudio Aránguiz, Lorena Suárez, Ricardo Ramones
 */
@Controller
@RequestMapping(path = "/pago")
public class PagoController {
	
	@Autowired
	PagoService pagoService;
	
	@Autowired
	UsuarioService usuarioService;
	
	/**
     * Muestra la lista de todos los pagos.
     *
     * @return un objeto {@link ModelAndView} con la lista de pagos y usuarios
     */
	@GetMapping(path = "/listar")
	public ModelAndView listarPagos() {
		List<Pago> listaPagos = pagoService.getAllPagos();
		List<Usuario> listaUsuarios = usuarioService.getAllUsuarios();
		List<String> listaRut = new ArrayList<>();
		
		// Asocia el RUT de los usuarios a los pagos
		for (Pago p : listaPagos) {
			for (Usuario u : listaUsuarios) {
				if (p.getId() == u.getId()) {
					listaRut.add(u.getRut());
				}
			}
		}
		
		ModelAndView modelo = new ModelAndView("listadoPago", "pagos", listaPagos);
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String auth = authorities.toString();
        // Agrega el rol del usuario autenticado al modelo para que esté disponible en la vista
		modelo.addObject("rol", auth);
		modelo.addObject("rut", listaRut);
		return modelo;
	}
	
	/**
     * Muestra el formulario para crear un nuevo pago.
     *Agrega el rol del usuario autenticado al modelo para que esté disponible en la vista.
     * @return un objeto {@link ModelAndView} con la lista de usuarios
     */
	@GetMapping(path = "/crear")
	public ModelAndView crearPago() {
		List<Usuario> listaUsuario = usuarioService.getAllUsuarios();
		ModelAndView modelo = new ModelAndView("crearPago", "usuarios", listaUsuario);
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        String auth = authorities.toString();
        // Agrega el rol del usuario autenticado al modelo para que esté disponible en la vista
		modelo.addObject("rol", auth);
		return modelo;
	}
	
	/**
     * Maneja la creación de un nuevo pago.
     *
     * @param pago objeto {@link Pago} que contiene los detalles del pago
     * @return una redirección a la lista de pagos
     */
	@PostMapping(path = "/crear")
	public String postCrearPago(@ModelAttribute Pago pago) {
		Pago newPago = pago;
		String fechaPago = pago.getFechaPago();
		// Formato de la fecha de pago
		String[] fechaArray = fechaPago.split("-");
		String fechaOrdenada = fechaArray[2] + "-" + fechaArray[1] + "-" + fechaArray[0];
		newPago.setFechaPago(fechaOrdenada);
		pagoService.savePagos(newPago);
		return "redirect:/pago/listar";
	}
}
