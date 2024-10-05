package grupo4.sprint6.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * Representa un pago realizado por un usuario en el sistema.
 * Está mapeada a la tabla {@code PAGOS} en la base de datos.
 * Cada pago está asociado a un usuario específico.
 * 
 * @author Ana Andrade
 * @author Carolina Diaz
 * @author Claudio Aranguiz
 * @author Lorena Suarez
 * @author Ricardo Ramones
 */
@Entity
@Table(name = "PAGOS")
public class Pago {

    /**
     * Identificador único del pago. Es autogenerado por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_P")
    private int idP;

    /**
     * Identificador del usuario asociado al pago. Este campo está relacionado
     * con la columna {@code id_U} de la tabla {@code USUARIO}.
     */
    @JoinColumn(name = "id_U")
    @Column(name = "id_U")
    private int id;

    /**
     * Monto del pago realizado. No puede ser nulo y tiene un máximo de 100 caracteres.
     */
    @Column(name = "monto", nullable = false, length = 100)
    private String monto;

    /**
     * Fecha en la que se realizó el pago. No puede ser nula y tiene un máximo de 100 caracteres.
     */
    @Column(name = "fecha_pago", nullable = false, length = 100)
    private String fechaPago;

    /**
     * Constructor por defecto de la clase {@code Pago}.
     */
    public Pago() {
    }

    /**
     * Constructor con parámetros para crear un pago con los campos especificados.
     * 
     * @param idP Identificador único del pago.
     * @param id Identificador del usuario asociado.
     * @param monto Monto del pago.
     * @param fechaPago Fecha en la que se realizó el pago.
     */
    public Pago(int idP, int id, String monto, String fechaPago) {
        super();
        this.idP = idP;
        this.id = id;
        this.monto = monto;
        this.fechaPago = fechaPago;
    }

    // Getters y Setters

    /**
     * Devuelve el identificador único del pago.
     * 
     * @return Identificador del pago.
     */
    public int getIdP() {
        return idP;
    }

    /**
     * Establece el identificador único del pago.
     * 
     * @param idP Identificador del pago a asignar.
     */
    public void setIdP(int idP) {
        this.idP = idP;
    }

    /**
     * Devuelve el identificador del usuario asociado al pago.
     * 
     * @return Identificador del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del usuario asociado al pago.
     * 
     * @param id Identificador del usuario a asignar.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el monto del pago realizado.
     * 
     * @return Monto del pago.
     */
    public String getMonto() {
        return monto;
    }

    /**
     * Establece el monto del pago realizado.
     * 
     * @param monto Monto del pago a asignar.
     */
    public void setMonto(String monto) {
        this.monto = monto;
    }

    /**
     * Devuelve la fecha en la que se realizó el pago.
     * 
     * @return Fecha del pago.
     */
    public String getFechaPago() {
        return fechaPago;
    }

    /**
     * Establece la fecha en la que se realizó el pago.
     * 
     * @param fechaPago Fecha del pago a asignar.
     */
    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    /**
     * Retorna una representación en cadena del objeto {@code Pago}.
     * 
     * @return Una cadena que representa el pago, incluyendo el identificador del pago, el usuario asociado, el monto y la fecha.
     */
    @Override
    public String toString() {
        return "Pago [idP=" + idP + ", id=" + id + ", monto=" + monto + ", fechaPago=" + fechaPago + "]";
    }
}
