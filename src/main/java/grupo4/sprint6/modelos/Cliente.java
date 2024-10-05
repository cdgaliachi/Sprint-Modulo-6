package grupo4.sprint6.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Representa un usuario de tipo cliente en el sistema, que hereda de la clase {@code Usuario}.
 * Esta clase contiene información específica de los clientes, como su teléfono y comuna.
 * Está mapeada a la tabla {@code CLIENTE} en la base de datos.
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
@Table(name = "CLIENTE")
@PrimaryKeyJoinColumn(name = "id_U")
public class Cliente extends Usuario {

    /**
     * Número de teléfono del cliente. Este campo no puede ser nulo y tiene un máximo de 100 caracteres.
     */
    @Column(name = "telefono", nullable = false, length = 100)
    private String telefono;

    /**
     * Comuna de residencia del cliente. Este campo no puede ser nulo y tiene un máximo de 100 caracteres.
     */
    @Column(name = "comuna", nullable = false, length = 100)
    private String comuna;

    /**
     * Constructor por defecto de la clase {@code Cliente}.
     */
    public Cliente() {
        super();
    }

    /**
     * Constructor con parámetros para crear un objeto {@code Cliente} con los campos especificados.
     * 
     * @param id Identificador único del cliente.
     * @param nombre Nombre del cliente.
     * @param rut RUT del cliente.
     * @param tipo Tipo de usuario (debe ser Cliente).
     * @param telefono Teléfono del cliente.
     * @param comuna Comuna de residencia del cliente.
     */
    public Cliente(int id, String nombre, String rut, TipoUsuario tipo, String telefono, String comuna) {
        super(id, nombre, rut, tipo);
        this.telefono = telefono;
        this.comuna = comuna;
    }

    // Getters y Setters

    /**
     * Devuelve el teléfono del cliente.
     * 
     * @return Teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del cliente.
     * 
     * @param telefono Teléfono a asignar.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve la comuna de residencia del cliente.
     * 
     * @return Comuna de residencia del cliente.
     */
    public String getComuna() {
        return comuna;
    }

    /**
     * Establece la comuna de residencia del cliente.
     * 
     * @param comuna Comuna a asignar.
     */
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    /**
     * Retorna una representación en cadena del objeto {@code Cliente}.
     * 
     * @return Una cadena que representa al cliente, incluyendo teléfono y comuna.
     */
    @Override
    public String toString() {
        return "Cliente [telefono=" + telefono + ", comuna=" + comuna + "]";
    }
}
