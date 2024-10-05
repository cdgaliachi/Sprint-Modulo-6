package grupo4.sprint6.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * Representa una visita realizada por un usuario en el sistema.
 * Está mapeada a la tabla {@code VISITAS} en la base de datos.
 * Cada visita está asociada a un usuario específico.
 * 
 * @author Ana Andrade
 * @author Carolina Diaz
 * @author Claudio Aranguiz
 * @author Lorena Suarez
 * @author Ricardo Ramones
 */
@Entity
@Table(name = "VISITAS")
public class Visita {

    /**
     * Identificador único de la visita. Es autogenerado por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_V")
    private int idV;

    /**
     * Identificador del usuario asociado a la visita. Este campo está relacionado
     * con la columna {@code id_U} de la tabla {@code USUARIO}.
     */
    @JoinColumn(name = "id_U")
    @Column(name = "id_U")
    private int id;

    /**
     * Fecha en la que se realizó la visita. No puede ser nula y tiene un máximo de 100 caracteres.
     */
    @Column(name = "fecha_visita", nullable = false, length = 100)
    private String fechaVisita;

    /**
     * Constructor por defecto de la clase {@code Visita}.
     */
    public Visita() {
    }

    /**
     * Constructor con parámetros para crear una visita con los campos especificados.
     * 
     * @param idV Identificador único de la visita.
     * @param id Identificador del usuario asociado.
     * @param fechaVisita Fecha de la visita.
     */
    public Visita(int idV, int id, String fechaVisita) {
        super();
        this.idV = idV;
        this.id = id;
        this.fechaVisita = fechaVisita;
    }

    // Getters y Setters

    /**
     * Devuelve el identificador único de la visita.
     * 
     * @return Identificador de la visita.
     */
    public int getIdV() {
        return idV;
    }

    /**
     * Establece el identificador único de la visita.
     * 
     * @param idV Identificador de la visita a asignar.
     */
    public void setIdV(int idV) {
        this.idV = idV;
    }

    /**
     * Devuelve el identificador del usuario asociado a la visita.
     * 
     * @return Identificador del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del usuario asociado a la visita.
     * 
     * @param id Identificador del usuario a asignar.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve la fecha en la que se realizó la visita.
     * 
     * @return Fecha de la visita.
     */
    public String getFechaVisita() {
        return fechaVisita;
    }

    /**
     * Establece la fecha en la que se realizó la visita.
     * 
     * @param fechaVisita Fecha de la visita a asignar.
     */
    public void setFechaVisita(String fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    /**
     * Retorna una representación en cadena del objeto {@code Visita}.
     * 
     * @return Una cadena que representa la visita, incluyendo el identificador del usuario y la fecha de la visita.
     */
    @Override
    public String toString() {
        return "Visitas [id=" + id + ", fechaVisita=" + fechaVisita + "]";
    }
}
