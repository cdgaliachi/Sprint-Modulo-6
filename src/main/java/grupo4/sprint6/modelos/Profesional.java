package grupo4.sprint6.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Representa un usuario de tipo profesional en el sistema, que hereda de la clase {@code Usuario}.
 * Esta clase contiene información específica de los profesionales, como su título y fecha de ingreso.
 * Está mapeada a la tabla {@code PROFESIONAL} en la base de datos.
 * 
 * <p>La clave primaria de esta tabla está relacionada con la clave primaria de la tabla {@code USUARIO}
 * a través de la anotación {@code PrimaryKeyJoinColumn}.
 * 
 * @author Ana Andrade
 * @author Carolina Diaz
 * @author Claudio Aranguiz
 * @author Lorena Suarez
 * @author Ricardo Ramones
 */
@Entity
@Table(name = "PROFESIONAL")
@PrimaryKeyJoinColumn(name = "id_U")
public class Profesional extends Usuario {

    /**
     * Título profesional del usuario. Este campo no puede ser nulo y tiene un máximo de 100 caracteres.
     */
    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    /**
     * Fecha de ingreso del profesional a la empresa. Este campo no puede ser nulo y tiene un máximo de 100 caracteres.
     */
    @Column(name = "fecha_ingreso", nullable = false, length = 100)
    private String fechaDeIngreso;

    /**
     * Constructor por defecto de la clase {@code Profesional}.
     */
    public Profesional() {
        super();
    }

    /**
     * Constructor con parámetros para crear un objeto {@code Profesional} con los campos especificados.
     * 
     * @param id Identificador único del profesional.
     * @param nombre Nombre del profesional.
     * @param rut RUT del profesional.
     * @param tipo Tipo de usuario (debe ser Profesional).
     * @param titulo Título profesional.
     * @param fechaDeIngreso Fecha de ingreso del profesional.
     */
    public Profesional(int id, String nombre, String rut, TipoUsuario tipo, String titulo, String fechaDeIngreso) {
        super(id, nombre, rut, tipo);
        this.titulo = titulo;
        this.fechaDeIngreso = fechaDeIngreso;
    }

    // Getters y Setters

    /**
     * Devuelve el título profesional del usuario.
     * 
     * @return Título profesional del usuario.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título profesional del usuario.
     * 
     * @param titulo Título profesional a asignar.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Devuelve la fecha de ingreso del profesional a la empresa.
     * 
     * @return Fecha de ingreso del profesional.
     */
    public String getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    /**
     * Establece la fecha de ingreso del profesional a la empresa.
     * 
     * @param fechaDeIngreso Fecha de ingreso a asignar.
     */
    public void setFechaDeIngreso(String fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    /**
     * Retorna una representación en cadena del objeto {@code Profesional}.
     * 
     * @return Una cadena que representa al profesional, incluyendo título y fecha de ingreso.
     */
    @Override
    public String toString() {
        return "Profesional [titulo=" + titulo + ", fechaDeIngreso=" + fechaDeIngreso + "]";
    }
}
