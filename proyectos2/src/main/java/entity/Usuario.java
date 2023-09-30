
package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    private String nombreUsuario;

	    @Column(nullable = false)
	    private String contrasena;

	    @Column(nullable = false)
	    private String nombre;

	    @Column(nullable = false)
	    private String apellido;

	    // Otros campos y métodos getter y setter

	    // Constructor vacío
	    public Usuario() {
	    }

	    // Constructor con parámetros
	    public Usuario(String nombreUsuario, String contrasena, String nombre, String apellido) {
	        this.nombreUsuario = nombreUsuario;
	        this.contrasena = contrasena;
	        this.nombre = nombre;
	        this.apellido = apellido;
	    }

	    // Getters y setters

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getNombreUsuario() {
	        return nombreUsuario;
	    }

	    public void setNombreUsuario(String nombreUsuario) {
	        this.nombreUsuario = nombreUsuario;
	    }

	    public String getContrasena() {
	        return contrasena;
	    }

	    public void setContrasena(String contrasena) {
	        this.contrasena = contrasena;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getApellido() {
	        return apellido;
	    }

	    public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }

	    // Otros campos y métodos getter y setter

	    @Override
	    public String toString() {
	        return "Usuario{" +
	                "id=" + id +
	                ", nombreUsuario='" + nombreUsuario + '\'' +
	                ", nombre='" + nombre + '\'' +
	                ", apellido='" + apellido + '\'' +
	                // Otros campos
	                '}';
	    }
}
