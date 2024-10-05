package grupo4.sprint6.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Representa un usuario administrativo en el sistema, que hereda de la clase {@code Usuario}.
 * La clase contiene información específica de los usuarios administrativos, como el área en la que trabajan
 * y su experiencia previa. Está mapeada a la tabla {@code ADMINISTRATIVO} en la base de datos.
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
@Table(name = "ADMINISTRATIVO")
@PrimaryKeyJoinColumn(name = "id_U")
public class Administrativo extends Usuario {

    /**
     * Área en la que trabaja el administrativo. Este campo no puede ser nulo y tiene un máximo de 100 caracteres.
     */
    @Column(name = "area", nullable = false, length = 100)
    private String area;
    
    /**
     * Experiencia previa del administrativo. Este campo no puede ser nulo y tiene un máximo de 100 caracteres.
     */
    @Column(name = "experiencia_previa", nullable = false, length = 100)
    private String experienciaPrevia;

    /**
     * Constructor por defecto de la clase {@code Administrativo}.
     */
    public Administrativo() {
        super();
    }

    /**
     * Constructor con parámetros para crear un objeto {@code Administrativo} con los campos especificados.
     * 
     * @param id Identificador único del usuario administrativo.
     * @param nombre Nombre del usuario administrativo.
     * @param rut RUT del usuario administrativo.
     * @param tipo Tipo de usuario (debe ser Administrativo).
     * @param area Área en la que trabaja el administrativo.
     * @param experienciaPrevia Experiencia previa del administrativo.
     */
    public Administrativo(int id, String nombre, String rut, TipoUsuario tipo, String area, String experienciaPrevia) {
        super(id, nombre, rut, tipo);
        this.area = area;
        this.experienciaPrevia = experienciaPrevia;
    }

    // Getters y Setters

    /**
     * Devuelve el área en la que trabaja el administrativo.
     * 
     * @return Área de trabajo del administrativo.
     */
    public String getArea() {
        return area;
    }

    /**
     * Establece el área de trabajo del administrativo.
     * 
     * @param area Área de trabajo a asignar.
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * Devuelve la experiencia previa del administrativo.
     * 
     * @return Experiencia previa del administrativo.
     */
    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    /**
     * Establece la experiencia previa del administrativo.
     * 
     * @param experienciaPrevia Experiencia previa a asignar.
     */
    public void setExperienciaPrevia(String experienciaPrevia) {
        this.experienciaPrevia = experienciaPrevia;
    }

    /**
     * Retorna una representación en cadena del objeto {@code Administrativo}.
     * 
     * @return Una cadena que representa al administrativo, incluyendo id, nombre, rut, tipo, área y experiencia previa.
     */
    @Override
    public String toString() {
        return "Administrativo [id=" + super.getId() + ", nombre=" + super.getNombre() + ", rut=" + super.getRut() +
               ", tipo=" + super.getTipo() + ", area=" + area + ", experienciaPrevia=" + experienciaPrevia + "]";
    }
}

