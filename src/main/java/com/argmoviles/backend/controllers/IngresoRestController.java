package com.argmoviles.backend.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.argmoviles.backend.models.entity.Ingreso;
import com.argmoviles.backend.models.services.IIngresoService;

/*@CrossOrigin(origins = { "http://localhost:4200" })*/
@CrossOrigin(origins = { "https://project.argmoviles.com" })
@RestController
@RequestMapping("/api")
public class IngresoRestController {
	
	@Autowired
	private IIngresoService ingresoService;
	
	
	@GetMapping("/ingresos")
	public List<Ingreso> index() {
		return ingresoService.findAll();
	}
	
	
	@GetMapping("/ingresos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Ingreso ingreso = null;
		Map<String, Object> response = new HashMap<>();

		try {
			ingreso = ingresoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error en la base de datos");
			response.put("error",
					e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (ingreso == null) {
			response.put("mensaje", "El ingreso ID:"
					.concat(id.toString().concat(" no existe en la basede datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Ingreso>(ingreso, HttpStatus.OK);
	}
	
	
	@PostMapping("/ingresos")
	public ResponseEntity<?> create(@RequestBody Ingreso ingreso) {

		Ingreso ingresoNew = null;
		Map<String, Object> response = new HashMap<>();

		try {
			ingresoNew = ingresoService.save(ingreso);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error",
					e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El ingreso ha sido creado con éxito!");
		response.put("ingreso", ingresoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/ingresos/{id}")
	public ResponseEntity<?> update(@RequestBody Ingreso ingreso, @PathVariable Long id) {

		Ingreso ingresoActual = ingresoService.findById(id);

		Ingreso ingresoUpdate = null;

		Map<String, Object> response = new HashMap<>();

		if (ingresoActual == null) {
			response.put("mensaje", "Error: no se pudo editar la ingreso ID:"
					.concat(id.toString().concat(" no existe en la basede datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			ingresoActual.setIngr_nombre(ingreso.getIngr_nombre());
			ingresoActual.setIngr_apellido(ingreso.getIngr_apellido());
			
			ingresoActual.setIngr_fecha_crea(ingreso.getIngr_fecha_crea());
			ingresoActual.setIngr_fecha_mod(ingreso.getIngr_fecha_mod());
			ingresoActual.setIngr_estado(ingreso.getIngr_estado());
		
			ingresoUpdate = ingresoService.save(ingresoActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error",
					e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El ingreso ha sido actualizado con éxito!");
		response.put("mensaje", ingresoUpdate);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/ingresos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();

		try {
			ingresoService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar ingreso de la base de datos");
			response.put("error",
					e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El ingreso ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	

}
