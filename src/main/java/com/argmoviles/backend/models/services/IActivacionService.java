package com.argmoviles.backend.models.services;

import java.sql.Date;
import java.util.List;

import com.argmoviles.backend.models.entity.Activacion;

public interface IActivacionService {

	public List<Activacion> findAll();

	public Activacion findById(Long id);

	public Activacion save(Activacion activacion);

	public void delete(Long id);
	

	public void saveExcel(List<Activacion> activacionList);
	

	public List<Activacion> filterByMonth(Date dateFilter);

	public List<Activacion> filterByDay(Date dateFilter);

	public Integer countActivacionByMonth(Long idVendedor, Long idProducto, Date dateFilter);
	
	public Integer countActivacionDia(Integer dia,Integer mes, Integer anio, Long idProducto);
	
	
	public List<Activacion> filterByColumnImporte(int value);
	public List<Activacion> filterByColumnSaldo(int value);
	public List<Activacion> filterByColumnInicial(int value);
	public List<Activacion> filterByColumnTipo(String value);
	public List<Activacion> filterByColumn(String value);
	public List<Activacion> filterByColumnUtilizacion(String value);
	public List<Activacion> filterByColumnCuota(int value);
	public List<Activacion> filterByColumnModalidad(String value);
	
	
	public List<Activacion> getColummsbyProducto(Long id);
	public List<Activacion> getColummsbyIngreso(Long id);
	public List<Activacion> getColummsbyVendedor(Long id);
	public List<Activacion> getColummsbyNeto(Long id);
	

}
