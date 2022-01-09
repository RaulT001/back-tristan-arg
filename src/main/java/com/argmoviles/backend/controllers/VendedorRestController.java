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

import com.argmoviles.backend.models.entity.Vendedor;
import com.argmoviles.backend.models.services.IVendedorService;

/*@CrossOrigin(origins = {"http://localhost:4200"})*/
@CrossOrigin(origins = {"https://project.argmoviles.com"})
@RestController
@RequestMapping("/api")
public class VendedorRestController {
	
	@Autowired
	private IVendedorService vendedorService;
	
	
	@GetMapping("/vendedores")
	public List<Vendedor> index() {
		return vendedorService.findAll();
	}
	
	
	@GetMapping("/vendedores/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Vendedor vendedor = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			vendedor = vendedorService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(vendedor == null) {
			response.put("mensaje", "El vendedor ID:".concat(id.toString().concat(" no existe en la basede datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Vendedor>(vendedor, HttpStatus.OK);
	}
	
	
	@PostMapping("/vendedores")//crear
	public ResponseEntity<?> create(@RequestBody Vendedor vendedor) {
		
		Vendedor vendedorNew = null;
		Map<String, Object> response = new HashMap<>();

		try {
			vendedorNew = vendedorService.save(vendedor);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El vendedor ha sido creado con éxito!");
		response.put("vendedor", vendedorNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/vendedores/{id}")//editar
	public ResponseEntity<?> update(@RequestBody Vendedor vendedor, @PathVariable Long id) {
		
		Vendedor vendedorActual = vendedorService.findById(id);
		
		Vendedor vendedorUpdate = null;
		
		Map<String, Object> response = new HashMap<>();

		if(vendedorActual == null) {
			response.put("mensaje", "Error: no se pudo editar el usuario ID:".concat(id.toString().concat(" no existe en la basede datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			vendedorActual.setVen_nombre(vendedor.getVen_nombre());
			vendedorActual.setVen_apellido(vendedor.getVen_apellido());
			vendedorActual.setVen_celular(vendedor.getVen_celular());
			vendedorActual.setVen_direccion(vendedor.getVen_direccion());
			vendedorActual.setVen_documento(vendedor.getVen_documento());
			vendedorActual.setVen_estado(vendedor.getVen_estado());
			vendedorActual.setVen_fecha_crea(vendedor.getVen_fecha_crea());
			vendedorActual.setVen_fecha_mod(vendedor.getVen_fecha_mod());
			vendedorActual.setVen_ffvv(vendedor.getVen_ffvv());
			
			vendedorUpdate = vendedorService.save(vendedorActual);
			
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El vendedor ha sido actualizado con éxito!");
		response.put("mensaje", vendedorUpdate);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/vendedores/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			vendedorService.delete(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar el vendor de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El vendor ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
