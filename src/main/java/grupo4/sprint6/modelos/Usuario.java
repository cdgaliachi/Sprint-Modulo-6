package grupo4.sprint6.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;



/**
 * Representa una entidad de usuario en el sistema. Esta clase utiliza la estrategia
 * de herencia {@code InheritanceType.JOINED} para almacenar diferentes tipos de usuarios
 * (Administrativo, Cliente, Profesional) en tablas separadas, pero compartiendo campos comunes.
 * 
 * <p>Esta clase forma parte del modelo y está mapeada a la tabla {@code USUARIO} en la base de datos.
 * Incluye campos como id, nombre, rut y tipo para representar un usuario genérico.
 * 
 * @author Ana Andrade
 * @author Carolina Diaz
 * @author Claudio Aranguiz
 * @author Lorena Suarez
 * @author Ricardo Ramones
 */
@Entity
@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.JOINED) // Estrategia para herencia con tablas separadas
public class Usuario {

    /**
     * Identificador único para el usuario. Este campo es autogenerado por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_U")
    private int id;

    /**
     * Nombre del usuario. Este campo no puede ser nulo y tiene un máximo de 100 caracteres.
     */
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    /**
     * RUT (identificador único nacional) del usuario. Este campo no puede ser nulo y 
     * tiene un máximo de 20 caracteres.
     */
    @Column(name = "rut", nullable = false, length = 20)
    private String rut;

    /**
     * Tipo de usuario, representado como un valor enumerado.
     * Puede ser {@code Administrativo}, {@code Cliente} o {@code Profesional}.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoUsuario tipo;

    /**
     * Constructor por defecto de la clase {@code Usuario}.
     */
    public Usuario() {}

    /**
     * Constructor con parámetros para crear un usuario con los campos especificados.
     * 
     * @param id     Identificador único del usuario.
     * @param nombre Nombre del usuario.
     * @param rut    RUT del usuario.
     * @param tipo   Tipo de usuario (Administrativo, Cliente, Profesional).
     */
    public Usuario(int id, String nombre, String rut, TipoUsuario tipo) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.tipo = tipo;
    }

		// Getters y Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getRut() {
	        return rut;
	    }

	    public void setRut(String rut) {
	        this.rut = rut;
	    }

	    public TipoUsuario getTipo() {
	        return tipo;
	    }

	    public void setTipo(TipoUsuario tipo) {
	        this.tipo = tipo;
	    }

	    public enum TipoUsuario {
	        Administrativo,
	        Cliente,
	        Profesional
	    }

	    @Override
	    public String toString() {
	        return "Usuario [id=" + id + ", nombre=" + nombre + ", rut=" + rut + ", tipo=" + tipo + "]";
	    }
}
