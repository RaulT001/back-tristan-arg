package com.argmoviles.backend.models.services;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.argmoviles.backend.models.dao.IActivacionDao;
import com.argmoviles.backend.models.dao.INetoDao;
import com.argmoviles.backend.models.dao.IProductoDao;
import com.argmoviles.backend.models.dao.IVendedorDao;
import com.argmoviles.backend.models.entity.Activacion;
import com.argmoviles.backend.models.entity.Neto;
import com.argmoviles.backend.models.entity.Producto;
import com.argmoviles.backend.models.entity.Vendedor;

@Service
public class ActivacionServiceImpl implements IActivacionService {

	@Autowired
	private IActivacionDao activacionDao;

	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
	private IVendedorDao vendedorDao;

	@Autowired
	private INetoDao netoDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Activacion> findAll() {
		return (List<Activacion>) activacionDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Activacion findById(Long id) {
		return activacionDao.findById(id).orElse(null);
	}

	@Transactional
	public Activacion save(Activacion activacion) {
		return activacionDao.save(activacion);
	}

	@Transactional
	public void delete(Long id) {
		activacionDao.deleteById(id);
	}

	
	@Override
	public void saveExcel(List<Activacion> activacionList) {
		activacionList.forEach(activacion -> {
			activacion = completeFields(activacion);
			
			if(activacion.getNombre_producto()!=null) {
				Producto prod = productoDao.findProductByName(activacion.getNombre_producto());
				if(prod==null) {
					prod = new Producto();
					prod.setProd_nombre(activacion.getNombre_producto());
					productoDao.save(prod);
				}
				activacion.setProducto(productoDao.findProductByName(activacion.getNombre_producto()));
			}
			if(activacion.getNombre_vendedor()!=null) {
				Vendedor vend = vendedorDao.findVendedorByName(activacion.getNombre_vendedor());
				if(vend==null) {
					vend = new Vendedor();
					vend.setVen_nombre(activacion.getNombre_vendedor());
					vendedorDao.save(vend);
				}
				activacion.setVendedor(vendedorDao.findVendedorByName(activacion.getNombre_vendedor()));				
			}
			if(activacion.getNombre_neto()!=null) {
				Neto neto = netoDao.findNetoByName(activacion.getNombre_neto());
				if(neto==null) {
					neto = new Neto();
					neto.setNet_pro(activacion.getNombre_neto());
					netoDao.save(neto);
				}
				activacion.setNeto(netoDao.findNetoByName(activacion.getNombre_neto()));	
			}
			
			
			//ffvv mal xd xd 
			if(activacion.getFf_vv()!=null) {
				Vendedor vend = vendedorDao.findVendedorByName(activacion.getFf_vv());
				if(vend==null) {
					vend = new Vendedor();
					vend.setVen_ffvv(activacion.getFf_vv());
					vendedorDao.save(vend);
				}
				activacion.setVendedor(vendedorDao.findVendedorByName(activacion.getFf_vv()));				
			}
			
			
			activacionDao.save(activacion);
		});

	}
	
	
	//condiciones - subir archivo
	public Activacion completeFields(Activacion act) {
		
		switch(act.getAct_utilizacion()){
		case "CHIP PREPAGO":
			if(act.getAct_numero_sec()==null) {
				act.setNombre_producto("ALTA PREPAGO");
				act.setNombre_neto("ALTA PREPAGO");
			}
			if(act.getAct_numero_sec()!=null) {
				act.setNombre_producto("PORTABILIDAD PREPAGO");
				act.setNombre_neto("PORTABILIDAD PREPAGO");
			}
			if(act.getAct_numero_sec()!=null && act.getAct_importe()>0) {
				act.setNombre_producto("PORTABILIDAD PREPAGO");
				act.setNombre_neto("PACK PREPAGO");
			}
			break;
		case "PREPAGO_B4":
			if(act.getAct_numero_sec()==null && act.getAct_importe()==null) {
				act.setNombre_producto("PORTABILIDAD PREPAGO");
				act.setNombre_neto("PORTABILIDAD PREPAGO");
			}
			break;
		case "REPOSICION CHIP PREPAGO":
			if(act.getAct_importe()>5) {
				act.setNombre_producto("REPOSICION");
				act.setNombre_neto("PACK PREPAGO");
			}else {
				act.setNombre_producto("REPOSICION");
				act.setNombre_neto("REPOSICION PREPAGO");
			}
			break;
		case "REPOSICION CHIP POSTOPAGO":
			if(act.getAct_numero_sec()==0) {
				act.setNombre_producto("REPOSICION");
				act.setNombre_neto("REPOSICION POSTPAGO");
			}
			break;
		case "":
			if(act.getAct_numero_sec()==null && act.getAct_importe()==null) {
				act.setNombre_producto("BLISTER");
				act.setNombre_neto("BLISTER");
			}
			break;
			
		}
		return act;
	}
	
	

	@Override
	public List<Activacion> filterByMonth(Date dateStart) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateStart);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return activacionDao.filterByMonth(dateStart, new Date(calendar.getTime().getTime()));
	}

	@Override
	public List<Activacion> filterByDay(Date dateDay) {
		return activacionDao.filterByDay(dateDay);
	}

	@Override
	public Integer countActivacionByMonth(Long idVendedor, Long idProducto, Date dateStart) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateStart);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return activacionDao.countActivacion(idVendedor, idProducto, dateStart,
				new Date(calendar.getTime().getTime()));
	}
	
	
	//borrar
	@Override
	public Integer countActivacionDia(Integer dia,Integer mes, Integer anio, Long idProducto) {
		return activacionDao.countActivacionDia(dia,mes,anio, idProducto);
	}
	
	
	
	
	//ventas x día de Neto
	@Override
	public Integer countActivacionDiaNeto(Integer dia, Integer mes, Integer anio, Long idNeto) {
		return activacionDao.countActivacionDiaNeto(dia,mes,anio, idNeto);
	}
	
	
	//ventas por promotor de neto
	
	

	
	public List<Activacion> filterByColumnImporte(int value) {
		return activacionDao.filterByColumnImporte(value);
	}
	public List<Activacion> filterByColumnSaldo(int value) {
		return activacionDao.filterByColumnSaldo(value);
	}
	public List<Activacion> filterByColumnInicial(int value) {
		return activacionDao.filterByColumnInicial(value);
	}
	public List<Activacion> filterByColumnTipo(String value) {
		return activacionDao.filterByColumnTipo(value);
	}
	public List<Activacion> filterByColumn(String value) {
		return activacionDao.filterByColumn(value);
	}
	public List<Activacion> filterByColumnUtilizacion(String value) {
		return activacionDao.filterByColumnUtilizacion(value);
	}
	public List<Activacion> filterByColumnCuota(int value) {
		return activacionDao.filterByColumnCuota(value);
	}
	public List<Activacion> filterByColumnModalidad(String value) {
		return activacionDao.filterByColumnModalidad(value);
	}
	
	
	public List<Activacion> getColummsbyProducto(Long id){
		return activacionDao.getColummsbyProducto(id);
	}
	public List<Activacion> getColummsbyIngreso(Long id){
		return activacionDao.getColummsbyIngreso(id);
	}
	public List<Activacion> getColummsbyVendedor(Long id){
		return activacionDao.getColummsbyVendedor(id);
	}
	public List<Activacion> getColummsbyNeto(Long id){
		return activacionDao.getColummsbyNeto(id);
	}

	

}
