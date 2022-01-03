package com.argmoviles.backend.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.argmoviles.backend.models.dto.VentasProveedorDTO;
import com.argmoviles.backend.models.entity.Activacion;
import com.argmoviles.backend.models.entity.Neto;
import com.argmoviles.backend.models.entity.Producto;
import com.argmoviles.backend.models.entity.Vendedor;
import com.argmoviles.backend.models.services.IActivacionService;
import com.argmoviles.backend.models.services.INetoService;
import com.argmoviles.backend.models.services.IProductoService;
import com.argmoviles.backend.models.services.IVendedorService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ActivacionRestController {

	@Autowired
	private IActivacionService activacionService;

	@Autowired
	private IVendedorService vendedorService;

	@Autowired
	private IProductoService productoService;
	
	//ventas x dia neto
	@Autowired
	private INetoService netoService;
	

	@GetMapping("/activaciones")
	public List<Activacion> index() {
		return activacionService.findAll();
	}

	@GetMapping("/activaciones/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Activacion activacion = null;
		Map<String, Object> response = new HashMap<>();

		try {
			activacion = activacionService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error en la base de datos");
			response.put("error",
					e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (activacion == null) {
			response.put("mensaje", "La activación ID:"
					.concat(id.toString().concat(" no existe en la basede datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Activacion>(activacion, HttpStatus.OK);
	}

	@PostMapping("/activaciones")
	public ResponseEntity<?> create(@RequestBody Activacion activacion) {

		Activacion activacionNew = null;
		Map<String, Object> response = new HashMap<>();

		try {
			activacionNew = activacionService.save(activacion);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error",
					e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La activacion ha sido creado con éxito!");
		response.put("activacion", activacionNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/activaciones/{id}")
	public ResponseEntity<?> update(@RequestBody Activacion activacion, @PathVariable Long id) {

		Activacion activacionActual = activacionService.findById(id);

		Activacion activacionUpdate = null;

		Map<String, Object> response = new HashMap<>();

		if (activacionActual == null) {
			response.put("mensaje", "Error: no se pudo editar la activacion ID:"
					.concat(id.toString().concat(" no existe en la basede datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			activacionActual.setAct_numero_sec(activacion.getAct_numero_sec());
			activacionActual.setAct_cliente(activacion.getAct_cliente());
			activacionActual.setAct_celular(activacion.getAct_celular());
			activacionActual.setAct_importe(activacion.getAct_importe());
			activacionActual.setAct_saldo(activacion.getAct_saldo());
			activacionActual.setAct_inicial(activacion.getAct_inicial());
			activacionActual.setAct_tipo(activacion.getAct_tipo());
			activacionActual.setAct_factura(activacion.getAct_factura());
			activacionActual.setAct_fecha(activacion.getAct_fecha());
			activacionActual.setAct_sap(activacion.getAct_sap());
			activacionActual.setAct_utilizacion(activacion.getAct_utilizacion());
			activacionActual.setAct_cuota(activacion.getAct_cuota());
			activacionActual.setAct_moneda(activacion.getAct_moneda());
			activacionActual.setAct_ciclo(activacion.getAct_ciclo());
			activacionActual.setAct_neto(activacion.getAct_neto());
			activacionActual.setAct_mayor_noventa(activacion.getAct_mayor_noventa());
			activacionActual.setAct_estado(activacion.getAct_estado());
			activacionActual.setAct_fecha_crea(activacion.getAct_fecha_crea());
			activacionActual.setAct_fecha_mod(activacion.getAct_fecha_mod());

			activacionActual.setOpcionpro(activacion.getOpcionpro());
			activacionActual.setVendedor(activacion.getVendedor());
			activacionActual.setCiclofac(activacion.getCiclofac());
			activacionActual.setDias(activacion.getDias());
			activacionActual.setComentario(activacion.getComentario());
			activacionActual.setUsuario(activacion.getUsuario());
			
			activacionActual.setAct_ingreso(activacion.getAct_ingreso());
			activacionActual.setAct_modalidad(activacion.getAct_modalidad());

			activacionActual.setVendedor(activacion.getVendedor());
			activacionActual.setProducto(activacion.getProducto());
			activacionActual.setCliente(activacion.getCliente());
			activacionActual.setNeto(activacion.getNeto());
			activacionActual.setIngreso(activacion.getIngreso());

			activacionUpdate = activacionService.save(activacionActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error",
					e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La activacion ha sido actualizado con éxito!");
		response.put("mensaje", activacionUpdate);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/activaciones/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();

		try {
			activacionService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar activaciones de la base de datos");
			response.put("error",
					e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La activación ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	
	//
	@PostMapping("/activaciones/activacionesExcel")
	public ResponseEntity<?> createExcel(@RequestBody List<Activacion> activacionList) {

		Map<String, Object> response = new HashMap<>();

		try {
			activacionService.saveExcel(activacionList);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error",
					e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La lista de activacion ha sido creado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}


	
	@PostMapping("/activaciones/filterByMonth")
	public List<Activacion> filterByMonth(@RequestBody Date dateFilter) {
		return activacionService.filterByMonth(dateFilter);
	}

	@PostMapping("/activaciones/filterByDay")
	public List<Activacion> filterByDay(@RequestBody Date dateFilter) {
		return activacionService.filterByDay(dateFilter);
	}

	// @GetMapping("/activaciones/usu")
	// public List<Usuario> listarUsuarios() {
	// return activacionService.findAllUsuarios();
	// }

	
	//no se borrar
	/*@PostMapping("/activaciones/ventaDia/{year}/{month}")
	public List<List<String>> ventaDia(@PathVariable Integer year,@PathVariable Integer month,@RequestBody List<Integer> lista) {

		List<List<String>> lsVentaPromotor = new ArrayList<List<String>>();

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.YEAR, year);
		
		
		List<Producto> lsProducto = new ArrayList<Producto>();
		if(lista.size()>0) {
			for(Integer id:lista) {
				Producto producto = productoService.findById(Long.valueOf(id));
				lsProducto.add(producto);
			}			
		}else {
			lsProducto = productoService.findAll();
		}

		List<String> lsLineaTotalProducto = new ArrayList<String>();
		int totaldias = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int[] arrayTotaldia = new int[totaldias];
		System.out.println(totaldias);
		for (int i = 0; i < lsProducto.size(); i++) {
			List<String> lsLinea = new ArrayList<String>();
			lsLinea.add(lsProducto.get(i).getProd_nombre());

			Integer cantidadTotalPromotor = 0;
			for (int day = 1;day<=totaldias;day++) {
				
				Integer cantidad = activacionService.countActivacionDia(day,month,year,
						lsProducto.get(i).getId());
				cantidadTotalPromotor += cantidad;
				lsLinea.add(cantidad.toString());
				arrayTotaldia[day-1] += cantidad;
			}
			lsLinea.add(cantidadTotalPromotor.toString());
			lsVentaPromotor.add(lsLinea);
		}

		lsLineaTotalProducto.add("Total general");
		Integer total = 0;
		for (Integer cant : arrayTotaldia) {
			lsLineaTotalProducto.add(cant.toString());
			total += cant;
		}
		lsLineaTotalProducto.add(total.toString());
		lsVentaPromotor.add(lsLineaTotalProducto);

		return lsVentaPromotor;
	} */
	
	
	//ventas x día de Neto
	@PostMapping("/activaciones/ventaDiaNeto/{year}/{month}")
	public List<List<String>> ventaDiaNeto(@PathVariable Integer year,@PathVariable Integer month,@RequestBody List<Integer> lista) {

		List<List<String>> lsVentaPromotor = new ArrayList<List<String>>();

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.YEAR, year);
		
		
		List<Neto> lsNeto = new ArrayList<Neto>();
		if(lista.size()>0) {
			for(Integer id:lista) {
				Neto neto = netoService.findById(Long.valueOf(id));
				lsNeto.add(neto);
			}			
		}else {
			lsNeto = netoService.findAll();
		}

		List<String> lsLineaTotalNeto = new ArrayList<String>();
		int totaldias = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int[] arrayTotaldia = new int[totaldias];
		System.out.println(totaldias);
		for (int i = 0; i < lsNeto.size(); i++) {
			List<String> lsLinea = new ArrayList<String>();
			lsLinea.add(lsNeto.get(i).getNet_pro());

			Integer cantidadTotalPromotor = 0;
			for (int day = 1;day<=totaldias;day++) {
				
				Integer cantidad = activacionService.countActivacionDiaNeto(day,month,year,
						lsNeto.get(i).getId());
				cantidadTotalPromotor += cantidad;
				lsLinea.add(cantidad.toString());
				arrayTotaldia[day-1] += cantidad;
			}
			lsLinea.add(cantidadTotalPromotor.toString());
			lsVentaPromotor.add(lsLinea);
		}

		lsLineaTotalNeto.add("Total general");
		Integer total = 0;
		for (Integer cant : arrayTotaldia) {
			lsLineaTotalNeto.add(cant.toString());
			total += cant;
		}
		lsLineaTotalNeto.add(total.toString());
		lsVentaPromotor.add(lsLineaTotalNeto);

		return lsVentaPromotor;
	}
	
	
	//borrar xd xd 
	/*@PostMapping("/activaciones/ventaPromotor")
	public List<List<String>> ventaPromotor(@RequestBody VentasProveedorDTO obj) {

		List<List<String>> lsVentaPromotor = new ArrayList<List<String>>();

		List<Vendedor> lsVendedor = new ArrayList<Vendedor>();
		
		if(obj.getLssellers().size()>0) {
			for(Integer id:obj.getLssellers()) {
				Vendedor vendedor = vendedorService.findById(Long.valueOf(id));
				lsVendedor.add(vendedor);
			}			
		}else {
			lsVendedor = vendedorService.findAll();
		}
		
		List<Producto> lsProducto = new ArrayList<Producto>();
		if(obj.getLsprods().size()>0) {
			for(Integer id:obj.getLsprods()) {
				Producto producto = productoService.findById(Long.valueOf(id));
				lsProducto.add(producto);
			}			
		}else {
			lsProducto = productoService.findAll();
		}
		
		List<String> lsLineaTotalProducto = new ArrayList<String>();
		int[] arrayTotalProducto = new int[lsProducto.size()];

		for (Vendedor vendedor : lsVendedor) {
			List<String> lsLinea = new ArrayList<String>();
			lsLinea.add(vendedor.getVen_nombre() + " " + vendedor.getVen_apellido());

			Integer cantidadTotalPromotor = 0;
			for (int i = 0; i < lsProducto.size(); i++) {
				Integer cantidad = activacionService.countActivacionByMonth(vendedor.getId(),
						lsProducto.get(i).getId(), obj.getDateFilter());
				cantidadTotalPromotor += cantidad;
				lsLinea.add(cantidad.toString());
				arrayTotalProducto[i] += cantidad;
			}
			lsLinea.add(cantidadTotalPromotor.toString());
			lsVentaPromotor.add(lsLinea);
		}

		lsLineaTotalProducto.add("Total general");
		Integer total = 0;
		for (Integer cant : arrayTotalProducto) {
			lsLineaTotalProducto.add(cant.toString());
			total += cant;
		}
		lsLineaTotalProducto.add(total.toString());
		lsVentaPromotor.add(lsLineaTotalProducto);

		return lsVentaPromotor;
	}*/
	
	
	//ventas por promotor de neto
	@PostMapping("/activaciones/ventaPromotorNeto")
	public List<List<String>> ventaPromotorNeto(@RequestBody VentasProveedorDTO obj) {

		List<List<String>> lsVentaPromotor = new ArrayList<List<String>>();

		
		List<Vendedor> lsVendedor = new ArrayList<Vendedor>();
		if(obj.getLssellers().size()>0) {
			for(Integer id:obj.getLssellers()) {
				Vendedor vendedor = vendedorService.findById(Long.valueOf(id));
				lsVendedor.add(vendedor);
			}			
		}else {
			lsVendedor = vendedorService.findAll();
		}
		
		
		List<Neto> lsNeto = new ArrayList<Neto>();
		if(obj.getLsnets().size()>0) {
			for(Integer id:obj.getLsnets()) {
				Neto neto = netoService.findById(Long.valueOf(id));
				lsNeto.add(neto);
			}			
		}else {
			lsNeto = netoService.findAll();
		}
		
		
		List<String> lsLineaTotalNeto = new ArrayList<String>();
		int[] arrayTotalNeto = new int[lsNeto.size()];

		for (Vendedor vendedor : lsVendedor) {
			List<String> lsLinea = new ArrayList<String>();
			lsLinea.add(vendedor.getVen_nombre() + " " + vendedor.getVen_apellido());		//borrar el apellido

			Integer cantidadTotalPromotor = 0;
			for (int i = 0; i < lsNeto.size(); i++) {
				Integer cantidad = activacionService.countActivacionByMonth(vendedor.getId(),lsNeto.get(i).getId(), obj.getDateFilter());
				
				cantidadTotalPromotor += cantidad;
				lsLinea.add(cantidad.toString());
				arrayTotalNeto[i] += cantidad;
			}
			lsLinea.add(cantidadTotalPromotor.toString());
			lsVentaPromotor.add(lsLinea);
		}

		lsLineaTotalNeto.add("Total general");
		Integer total = 0;
		for (Integer cant : arrayTotalNeto) {
			lsLineaTotalNeto.add(cant.toString());
			total += cant;
		}
		lsLineaTotalNeto.add(total.toString());
		lsVentaPromotor.add(lsLineaTotalNeto);

		return lsVentaPromotor;
	}
	
	
	//puntos por promotor de neto
	@PostMapping("/activaciones/puntoPromotorNeto")
	public List<List<String>> puntoPromotorNeto(@RequestBody VentasProveedorDTO obj) {

		List<List<String>> lsVentaPromotor = new ArrayList<List<String>>();

		
		List<Vendedor> lsVendedor = new ArrayList<Vendedor>();
		if(obj.getLssellers().size()>0) {
			for(Integer id:obj.getLssellers()) {
				Vendedor vendedor = vendedorService.findById(Long.valueOf(id));
				lsVendedor.add(vendedor);
			}			
		}else {
			lsVendedor = vendedorService.findAll();
		}
		
		
		List<Neto> lsNeto = new ArrayList<Neto>();
		if(obj.getLsnets().size()>0) {
			for(Integer id:obj.getLsnets()) {
				Neto neto = netoService.findById(Long.valueOf(id));
				lsNeto.add(neto);
			}			
		}else {
			lsNeto = netoService.findAll();
		}
		
		
		
		List<String> lsLineaTotalNeto = new ArrayList<String>();
		int[] arrayTotalNeto = new int[lsNeto.size()];

		for (Vendedor vendedor : lsVendedor) {
			List<String> lsLinea = new ArrayList<String>();
			lsLinea.add(vendedor.getVen_nombre() );		//
			
			Integer cantidadTotalPromotor = 0;
			for (int i = 0; i < lsNeto.size(); i++) {
				Integer cantidad = activacionService.countActivacionByMonth(vendedor.getId(),lsNeto.get(i).getId(), obj.getDateFilter());
				cantidadTotalPromotor += cantidad;
				lsLinea.add(cantidad.toString());
				arrayTotalNeto[i] += cantidad;
			}
			lsLinea.add(cantidadTotalPromotor.toString());
			lsVentaPromotor.add(lsLinea);
		}

		lsLineaTotalNeto.add("Total general");
		Integer total = 0;
		for (Integer cant : arrayTotalNeto) {
			lsLineaTotalNeto.add(cant.toString());
			total += cant;
		}
		lsLineaTotalNeto.add(total.toString());
		lsVentaPromotor.add(lsLineaTotalNeto);

		return lsVentaPromotor;
	}
	
	
	
	@GetMapping("/activaciones/filterByColumnImporte/{value}")
	public List<Activacion> filterByColumnImporte(@PathVariable int value) {
		return activacionService.filterByColumnImporte(value);
	}
	@GetMapping("/activaciones/filterByColumnSaldo/{value}")
	public List<Activacion> filterByColumnSaldo(@PathVariable int value) {
		return activacionService.filterByColumnSaldo(value);
	}
	@GetMapping("/activaciones/filterByColumnInicial/{value}")
	public List<Activacion> filterByColumnInicial(@PathVariable int value) {
		return activacionService.filterByColumnInicial(value);
	}
	@GetMapping("/activaciones/filterByColumnTipo/{value}")
	public List<Activacion> filterByColumnTipo(@PathVariable String value) {
		return activacionService.filterByColumnTipo(value);
	}
	@GetMapping("/activaciones/filterByColumn/{value}")
	public List<Activacion> filterByColumn(@PathVariable String value) {
		return activacionService.filterByColumn(value);
	}
	@GetMapping("/activaciones/filterByColumnUtilizacion/{value}")
	public List<Activacion> filterByColumnUtilizacion(@PathVariable String value) {
		return activacionService.filterByColumnUtilizacion(value);
	}
	@GetMapping("/activaciones/filterByColumnCuota/{value}")
	public List<Activacion> filterByColumnCuota(@PathVariable int value) {
		return activacionService.filterByColumnCuota(value);
	}
	@GetMapping("/activaciones/filterByColumnModalidad/{value}")
	public List<Activacion> filterByColumnModalidad(@PathVariable String value) {
		return activacionService.filterByColumnModalidad(value);
	}
	
	
	@GetMapping("/activaciones/filterbyProducto/{id}")
	public List<Activacion> filterbyProducto(@PathVariable Long id) {
		return activacionService.getColummsbyProducto(id);
	}
	@GetMapping("/activaciones/filterbyIngreso/{id}")
	public List<Activacion> filterbyIngreso(@PathVariable Long id) {
		return activacionService.getColummsbyIngreso(id);
	}
	@GetMapping("/activaciones/filterbyVendedor/{id}")
	public List<Activacion> filterbyVendedor(@PathVariable Long id) {
		return activacionService.getColummsbyVendedor(id);
	}
	@GetMapping("/activaciones/filterbyNeto/{id}")
	public List<Activacion> filterbyNeto(@PathVariable Long id) {
		return activacionService.getColummsbyNeto(id);
	}
	
	
}
