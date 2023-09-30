package entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@Entity
@Table(name="tarea")


public class Tarea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private static final Logger LOG = LoggerFactory.getLogger(Tarea.class);

	
	private long id;
	private String nombre;
	private String fecha;
	private String etiqueta;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	
	 public void realizarTarea() {
	        LOG.info("Realizando la tarea: {}", nombre);
	        // Agrega la lógica para realizar la tarea aquí...
	    }

	    public void cambiarEtiqueta(String nuevaEtiqueta) {
	        etiqueta = nuevaEtiqueta;
	        LOG.info("Cambiando etiqueta a: {}", nuevaEtiqueta);
	        // Agrega la lógica para cambiar la etiqueta aquí...
	    }
	






	


}
