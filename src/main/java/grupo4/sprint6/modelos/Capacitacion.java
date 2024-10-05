package grupo4.sprint6.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representa una capacitación en el sistema.
 * Está mapeada a la tabla {@code CAPACITACION} en la base de datos.
 * Cada capacitación incluye detalles como el día, hora, lugar, duración y la cantidad de asistentes.
 * 
 * @author Ana Andrade
 * @author Carolina Diaz
 * @author Claudio Aranguiz
 * @author Lorena Suarez
 * @author Ricardo Ramones
 */
@Entity
@Table(name = "CAPACITACION")
public class Capacitacion {

    /**
     * Identificador único de la capacitación. Es autogenerado por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Identificador de la capacitación.
     */
    @Column(name = "identificador")
    private int identificador;

    /**
     * Día en que se llevará a cabo la capacitación.
     */
    @Column(name = "dia")
    private String dia;

    /**
     * Hora en que se llevará a cabo la capacitación.
     */
    @Column(name = "hora")
    private String hora;

    /**
     * Lugar donde se llevará a cabo la capacitación.
     */
    @Column(name = "lugar")
    private String lugar;

    /**
     * Duración de la capacitación.
     */
    @Column(name = "duracion")
    private String duracion;

    /**
     * Cantidad de asistentes a la capacitación.
     */
    @Column(name = "cantidad_asistentes")
    private int cantidadAsistentes;

    /**
     * Constructor por defecto de la clase {@code Capacitacion}.
     */
    public Capacitacion() {
    }

    /**
     * Constructor con parámetros para crear una capacitación con los campos especificados.
     * 
     * @param id Identificador único de la capacitación.
     * @param identificador Identificador de la capacitación.
     * @param dia Día en que se llevará a cabo la capacitación.
     * @param hora Hora en que se llevará a cabo la capacitación.
     * @param lugar Lugar donde se llevará a cabo la capacitación.
     * @param duracion Duración de la capacitación.
     * @param cantidadAsistentes Cantidad de asistentes a la capacitación.
     */
    public Capacitacion(int id, int identificador, String dia, String hora, String lugar, String duracion,
           int cantidadAsistentes) {
        this.id = id;
        this.identificador = identificador;   
        this.dia = dia;						
        this.hora = hora;					
        this.lugar = lugar;					
        this.duracion = duracion;			
        this.cantidadAsistentes = cantidadAsistentes; 
    }

    // Getters y setters

    /**
     * Devuelve el identificador único de la capacitación.
     * 
     * @return Identificador único de la capacitación.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único de la capacitación.
     * 
     * @param id Identificador único a asignar.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el identificador de la capacitación.
     * 
     * @return Identificador de la capacitación.
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Establece el identificador de la capacitación.
     * 
     * @param identificador Identificador a asignar.
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * Devuelve el día en que se llevará a cabo la capacitación.
     * 
     * @return Día de la capacitación.
     */
    public String getDia() {
        return dia;
    }

    /**
     * Establece el día en que se llevará a cabo la capacitación.
     * 
     * @param dia Día a asignar.
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * Devuelve la hora en que se llevará a cabo la capacitación.
     * 
     * @return Hora de la capacitación.
     */
    public String getHora() {
        return hora;
    }

    /**
     * Establece la hora en que se llevará a cabo la capacitación.
     * 
     * @param hora Hora a asignar.
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * Devuelve el lugar donde se llevará a cabo la capacitación.
     * 
     * @return Lugar de la capacitación.
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Establece el lugar donde se llevará a cabo la capacitación.
     * 
     * @param lugar Lugar a asignar.
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * Devuelve la duración de la capacitación.
     * 
     * @return Duración de la capacitación.
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * Establece la duración de la capacitación.
     * 
     * @param duracion Duración a asignar.
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    /**
     * Devuelve la cantidad de asistentes a la capacitación.
     * 
     * @return Cantidad de asistentes.
     */
    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    /**
     * Establece la cantidad de asistentes a la capacitación.
     * 
     * @param cantidadAsistentes Cantidad de asistentes a asignar.
     */
    public void setCantidadAsistentes(int cantidadAsistentes) {
        this.cantidadAsistentes = cantidadAsistentes;
    }

    /**
     * Retorna una representación en cadena del objeto {@code Capacitacion}.
     * 
     * @return Una cadena que representa la capacitación, incluyendo el identificador, día, hora, lugar, duración y cantidad de asistentes.
     */
    @Override
    public String toString() {
        return "Capacitacion [identificador=" + identificador + ", Dia=" + dia + ", Hora="
                + hora + ", Lugar=" + lugar + ", Duracion=" + duracion + ", Cantidad de Asistentes=" + cantidadAsistentes + "]";
    }
}
