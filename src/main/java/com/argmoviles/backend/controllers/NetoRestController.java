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

import com.argmoviles.backend.models.entity.Neto;
import com.argmoviles.backend.models.services.INetoService;

@CrossOrigin(origins = { "http://localhost:4200" })
//@CrossOrigin(origins = { "https://backmoviles-front-moviles-prue.herokuapp.com" })
@RestController
@RequestMapping("/api")
public class NetoRestController {

	@Autowired
	INetoService netoService;

	@GetMapping("/netos")
	public List<Neto> get() {
		return netoService.findAll();
	}
	
	
	
	//yo xd xd 
	//@GetMapping("/netos")
	//public List<Neto> index() {
	//	return netoService.findAll();
	//}
	
	
	@GetMapping("/netos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Neto neto = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			neto = netoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(neto == null) {
			response.put("mensaje", "El neto ID:".concat(id.toString().concat(" no existe en la basede datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Neto>(neto, HttpStatus.OK);
	}
	
	
	@PostMapping("/netos")
	public ResponseEntity<?> create(@RequestBody Neto neto) {
		
		Neto netoNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			netoNew = netoService.save(neto);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Neto ha sido creado con éxito!");
		response.put("neto", netoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/netos/{id}")
	public ResponseEntity<?> update(@RequestBody Neto neto, @PathVariable Long id) {
		
		Neto netoActual = netoService.findById(id);
		
		Neto netoUpdate = null;
		
		Map<String, Object> response = new HashMap<>();
		
		if(netoActual == null) {
			response.put("mensaje", "Error: no se pudo editar neto ID:".concat(id.toString().concat(" no existe en la basede datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			netoActual.setNet_pro(neto.getNet_pro());

			
			netoUpdate = netoService.save(netoActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Neto ha sido actualizado con éxito!");
		response.put("mensaje", netoUpdate);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/netos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			netoService.delete(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar neto de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Neto ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);		
	}
	
}
