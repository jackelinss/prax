package Etiqueta.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dao.TareaRepository;
import entity.Etiqueta;
import entity.Tarea;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import repo.EtiquetaRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@Data
@Entity
@Table(name="etiquetas")
public class EtiquetaController {
	private static final Logger LOG = LoggerFactory.getLogger(EtiquetaController.class);

	@Autowired()
	EtiquetaRepository repo;
	
	@GetMapping("/etiquetas")
	public List<Etiqueta> listarEtiqueta() {
		List<Etiqueta> et = repo.findAll();
		for (Etiqueta usuario : et) {
		System.out.println(usuario.getId() + ": " + usuario.getNometiquetas() );
		
	

		}
		return et;
		
	}
	
	
	// create employee rest api
	@PostMapping("/etiqueta2")
	public Etiqueta agregarEtiqueta(@RequestBody Etiqueta etiqueta) {
		 LOG.info("Agregando nueva tarea: {}", etiqueta.getNometiquetas());
	    return repo.save(etiqueta);
	}

	// get employee by id rest api
		@GetMapping("/etiqueta2/{id}")
		public ResponseEntity<Etiqueta> getEmployeeById(@PathVariable Long id) {
			 LOG.info("Consultando tarea con ID: {}", id);
			Etiqueta employee = repo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			return ResponseEntity.ok(employee);
		}
		
		// update employee rest api
		
		@PutMapping("/etiqueta2/{id}")
		public ResponseEntity<Etiqueta> updateEmployee(@PathVariable Long id, @RequestBody Etiqueta employeeDetails){
			  LOG.info("Actualizando tarea con ID: {}", id);
			Etiqueta employee = repo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			
			employee.setNometiquetas(employeeDetails.getNometiquetas());
			
			Etiqueta updatedEmployee = repo.save(employee);
			return ResponseEntity.ok(updatedEmployee);
		}
	
	
	
	// delete employee rest api
		@DeleteMapping("/etiqueta2/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
			 LOG.info("Eliminando tarea con ID: {}", id);
			Etiqueta employee = repo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			
			repo.delete(employee);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
	
	
		
		


}
