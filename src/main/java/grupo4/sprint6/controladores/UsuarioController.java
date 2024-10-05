package grupo4.sprint6.controladores;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import grupo4.sprint6.modelos.Administrativo;
import grupo4.sprint6.modelos.Cliente;
import grupo4.sprint6.modelos.Profesional;
import grupo4.sprint6.modelos.Usuario;
import grupo4.sprint6.modelos.Usuario.TipoUsuario;
import grupo4.sprint6.services.AdministrativoService;
import grupo4.sprint6.services.ClienteService;
import grupo4.sprint6.services.ProfesionalService;
import grupo4.sprint6.services.UsuarioService;

/**
 * Controlador que gestiona las operaciones relacionadas con los usuarios en el
 * sistema. Este controlador permite listar, crear, actualizar y eliminar
 * usuarios de tipo Cliente, Profesional y Administrativo.
 * 
 * <p>
 * Autorización: El acceso a los métodos está protegido por la seguridad de
 * Spring.
 * </p>
 * 
 * @authors: Ana Andrade, Carolina Díaz, Claudio Aránguiz, Lorena Suárez,
 *           Ricardo Ramones
 */
@Controller
@RequestMapping(path = "/usuario")
public class UsuarioController {
	/** Objeto {@link Logger} que contiene los métodos de depuración */
	private static final Logger logger = LogManager.getLogger(UsuarioController.class);

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	ClienteService clienteService;

	@Autowired
	ProfesionalService profesionalService;

	@Autowired
	AdministrativoService administrativoService;

	/**
	 * Método que lista todos los usuarios, clientes, profesionales y
	 * administrativos.
	 * 
	 * @return ModelAndView que contiene la vista de listado de usuarios y los datos
	 *         de usuarios.
	 */
	@GetMapping(path = "/listar")
	public ModelAndView listarUsuario() {
		List<Usuario> listUsuario = usuarioService.getAllUsuarios();
		List<Cliente> listCliente = clienteService.getAllClientes();
		List<Profesional> listProfesional = profesionalService.getAllProfesionales();
		List<Administrativo> listAdministrativo = administrativoService.getAllAdministrativos();
		ModelAndView modelo = new ModelAndView("listadoUsuario", "usuarios", listUsuario);
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		String auth = authorities.toString();
		modelo.addObject("clientes", listCliente);
		modelo.addObject("profesionales", listProfesional);
		modelo.addObject("administrativos", listAdministrativo);
		modelo.addObject("rol", auth);
		return modelo;
	}

	/**
	 * Método que muestra el formulario para crear un nuevo usuario.
	 * 
	 * @param nombre  Nombre opcional del usuario.
	 * @param request Solicitud HTTP actual.
	 * @param modelo  Modelo para la vista.
	 * @return Nombre de la vista de creación de usuario.
	 */
	@GetMapping(path = "/crear")
	public String crearUsuario(@PathVariable Optional<String> nombre, HttpServletRequest request, Model modelo) {
		// Depuración
		logger.info("Solicitud GET: {}", request.getRequestURI());
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		String auth = authorities.toString();
		modelo.addAttribute("rol", auth);
		// Mostrar página
		return "crearUsuario";
	}

	/**
	 * Método que procesa la creación de un nuevo usuario en el sistema.
	 * 
	 * @param nombre            Nombre del nuevo usuario.
	 * @param rut               RUT del nuevo usuario.
	 * @param tipo              Tipo de usuario (Cliente, Profesional,
	 *                          Administrativo).
	 * @param telefono          Teléfono opcional del cliente.
	 * @param comuna            Comuna opcional del cliente.
	 * @param area              Área opcional del administrativo.
	 * @param experienciaPrevia Experiencia previa opcional del administrativo.
	 * @param titulo            Título opcional del profesional.
	 * @param fechaIngreso      Fecha de ingreso opcional del profesional.
	 * @return ModelAndView que redirige a la lista de usuarios.
	 */
	@PostMapping(path = "/crear")
	public ModelAndView postCrearUsuario(@RequestParam("nombre") String nombre, @RequestParam("rut") String rut,
			@RequestParam("tipo") String tipo, @RequestParam(value = "telefono", required = false) String telefono,
			@RequestParam(value = "comuna", required = false) String comuna,
			@RequestParam(value = "area", required = false) String area,
			@RequestParam(value = "experienciaPrevia", required = false) String experienciaPrevia,
			@RequestParam(value = "titulo", required = false) String titulo,
			@RequestParam(value = "fechaIngreso", required = false) String fechaIngreso) {
		if ("Cliente".equals(tipo)) {
			Cliente cliente = new Cliente();
			cliente.setNombre(nombre);
			cliente.setRut(rut);
			cliente.setTipo(TipoUsuario.Cliente);
			cliente.setTelefono(telefono);
			cliente.setComuna(comuna);
			clienteService.saveCliente(cliente);
		} else if ("Profesional".equals(tipo)) {
			Profesional profesional = new Profesional();
			profesional.setNombre(nombre);
			profesional.setRut(rut);
			profesional.setTipo(TipoUsuario.Profesional);
			profesional.setTitulo(titulo);
			String[] fechaArray = fechaIngreso.split("-");
			String fechaOrdenada = fechaArray[2] + "-" + fechaArray[1] + "-" + fechaArray[0];
			profesional.setFechaDeIngreso(fechaOrdenada);
			profesionalService.saveProfesional(profesional);
		} else if ("Administrativo".equals(tipo)) {
			Administrativo administrativo = new Administrativo();
			administrativo.setNombre(nombre);
			administrativo.setRut(rut);
			administrativo.setTipo(TipoUsuario.Administrativo);
			administrativo.setArea(area);
			administrativo.setExperienciaPrevia(experienciaPrevia);
			System.out.println(administrativo.toString());
			administrativoService.saveAdministrativo(administrativo);
		}
		return new ModelAndView("redirect:/usuario/listar");
	}

	/**
	 * Método que procesa la actualización de un usuario existente.
	 * 
	 * @param nombre            Nombre del usuario.
	 * @param rut               RUT del usuario.
	 * @param tipo              Tipo de usuario (Cliente, Profesional,
	 *                          Administrativo).
	 * @param telefono          Teléfono opcional del cliente.
	 * @param comuna            Comuna opcional del cliente.
	 * @param area              Área opcional del administrativo.
	 * @param experienciaPrevia Experiencia previa opcional del administrativo.
	 * @param titulo            Título opcional del profesional.
	 * @param fechaIngreso      Fecha de ingreso opcional del profesional.
	 * @param id                Identificador del usuario a actualizar.
	 * @return ModelAndView que redirige a la lista de usuarios.
	 */
	@PostMapping(path = "/actualizar")
	public ModelAndView postActualizarUsuario(@RequestParam("nombre") String nombre, @RequestParam("rut") String rut,
			@RequestParam("tipo") String tipo, @RequestParam(value = "telefono", required = false) String telefono,
			@RequestParam(value = "comuna", required = false) String comuna,
			@RequestParam(value = "area", required = false) String area,
			@RequestParam(value = "experienciaPrevia", required = false) String experienciaPrevia,
			@RequestParam(value = "titulo", required = false) String titulo,
			@RequestParam(value = "fechaIngreso", required = false) String fechaIngreso,
			@RequestParam(value = "id", required = false) int id) {
		if ("Cliente".equals(tipo)) {
			Cliente cliente = new Cliente();
			cliente.setNombre(nombre);
			cliente.setRut(rut);
			cliente.setTipo(TipoUsuario.Cliente);
			cliente.setTelefono(telefono);
			cliente.setComuna(comuna);
			clienteService.updateCliente(id, cliente);
		} else if ("Profesional".equals(tipo)) {
			Profesional profesional = new Profesional();
			profesional.setNombre(nombre);
			profesional.setRut(rut);
			profesional.setTipo(TipoUsuario.Profesional);
			profesional.setTitulo(titulo);
			String[] fechaArray = fechaIngreso.split("-");
			String fechaOrdenada = fechaArray[2] + "-" + fechaArray[1] + "-" + fechaArray[0];
			profesional.setFechaDeIngreso(fechaOrdenada);
			profesionalService.updateProfesional(id, profesional);
		} else if ("Administrativo".equals(tipo)) {
			Administrativo administrativo = new Administrativo();
			administrativo.setNombre(nombre);
			administrativo.setRut(rut);
			administrativo.setTipo(TipoUsuario.Administrativo);
			administrativo.setArea(area);
			administrativo.setExperienciaPrevia(experienciaPrevia);
			administrativoService.updateAdministrativo(id, administrativo);
		}
		return new ModelAndView("redirect:/usuario/listar");
	}

	/**
	 * Método que procesa la eliminación de un usuario.
	 * 
	 * @param id Identificador del usuario a eliminar.
	 * @return Redirección a la lista de usuarios.
	 */
	@PostMapping(path = "/borrar")
	public String postBorrarUsuario(@RequestParam int id) {
		usuarioService.deleteUsuario(id);
		return "redirect:/usuario/listar";
	}
}