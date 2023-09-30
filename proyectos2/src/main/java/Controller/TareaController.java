package Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.TareaRepository;
import entity.Etiqueta;
import entity.Tarea;


import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class TareaController {

	 private static final Logger LOG = LoggerFactory.getLogger(TareaController.class);
	
	@Autowired()
	TareaRepository repo;
	
	@GetMapping("/tareas")
	public List<Tarea> listarUsuarios() {
		List<Tarea> usuarios = repo.findAll();
		for (Tarea usuario : usuarios) {
		System.out.println(usuario.getId() + ": " + usuario.getNombre() );
		
	

		}
		return usuarios;
		
	}
	
	// create employee rest api
		@PostMapping("/taread")
		public Tarea agregarEtiqueta(@RequestBody Tarea tar) {
			LOG.info("Agregando nueva tarea: {}", tar.getNombre());
		    return repo.save(tar);
		}

		// get employee by id rest api
			@GetMapping("/taread/{id}")
			public ResponseEntity<Tarea> getEmployeeById(@PathVariable Long id) {
				LOG.info("Consultando tarea con ID: {}", id);
				Tarea employee = repo.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
				return ResponseEntity.ok(employee);
			}
			
			// update employee rest api
			
			@PutMapping("/taread/{id}")
			public ResponseEntity<Tarea> updateEmployee(@PathVariable Long id, @RequestBody Tarea employeeDetails){
				
				LOG.info("Consultando tarea con ID: {}", id);
				Tarea tars1 = repo.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
				
				tars1.setNombre(employeeDetails.getNombre());
				tars1.setFecha(employeeDetails.getFecha());
				tars1.setEtiqueta(employeeDetails.getEtiqueta());
				
				Tarea updatedEmployee = repo.save(tars1);
				return ResponseEntity.ok(updatedEmployee);
			}
		
		
		
		// delete employee rest api
			@DeleteMapping("/taread/{id}")
			public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
				LOG.info("Eliminando tarea con ID: {}", id);
				Tarea employee = repo.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
				
				repo.delete(employee);
				Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
			}
		
		
	
}
