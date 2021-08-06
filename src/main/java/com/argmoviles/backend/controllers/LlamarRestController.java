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

import com.argmoviles.backend.models.dto.LlamarDTO;
import com.argmoviles.backend.models.entity.Llamar;
import com.argmoviles.backend.models.services.ILlamarService;

@CrossOrigin(origins = {"http://localhost:4200"})
//@CrossOrigin(origins = { "https://backmoviles-front-moviles-prue.herokuapp.com" })
@RestController
@RequestMapping("/api")
public class LlamarRestController {
	
	@Autowired
	private ILlamarService llamarService;
	
	
	@GetMapping("/llamadas")
	public List<Llamar> index() {
		return llamarService.findAll();
	}
	
	
	@GetMapping("/llamadas/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Llamar llamar = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			llamar = llamarService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(llamar == null) {
			response.put("mensaje", "La llamada ID:".concat(id.toString().concat(" no existe en la basede datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Llamar>(llamar, HttpStatus.OK);
	}
	
	
	@PostMapping("/llamadas")
	public ResponseEntity<?> create(@RequestBody LlamarDTO llamarDTO) {
		
		Llamar llamarNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			Llamar llamar = llamarDTO.getLlamar();
			llamar.setActivacion(llamarDTO.getActivacion());
			llamarNew = llamarService.save(llamar);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La llamada ha sido creado con éxito!");
		response.put("llamar", llamarNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/llamadas/{id}")
	public ResponseEntity<?> update(@RequestBody Llamar llamar, @PathVariable Long id) {
		
		Llamar llamarActual = llamarService.findById(id);
		
		Llamar llamarUpdate = null;
		
		Map<String, Object> response = new HashMap<>();
		
		if(llamarActual == null) {
			response.put("mensaje", "Error: no se pudo editar la llamada ID:".concat(id.toString().concat(" no existe en la basede datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			llamarActual.setLlam_fecha_inicio(llamar.getLlam_fecha_inicio());
			llamarActual.setLlam_deuda(llamar.getLlam_deuda());
			llamarActual.setLlam_monto(llamar.getLlam_monto());
			llamarActual.setLlam_fecha_fin(llamar.getLlam_fecha_fin());
			
			llamarActual.setLlam_fecha_crea(llamar.getLlam_fecha_crea());
			llamarActual.setLlam_fecha_mod(llamar.getLlam_fecha_mod());
			
			llamarUpdate = llamarService.save(llamarActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La llamada ha sido actualizado con éxito!");
		response.put("mensaje", llamarUpdate);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/llamadas/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			llamarService.delete(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar el registro de llamada de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El registro llamada ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);		
	}
	
}
