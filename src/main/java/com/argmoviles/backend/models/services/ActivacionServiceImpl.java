package com.argmoviles.backend.models.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.argmoviles.backend.models.dao.IActivacionDao;
import com.argmoviles.backend.models.entity.Activacion;

@Service
public class ActivacionServiceImpl implements IActivacionService {

	@Autowired
	private IActivacionDao activacionDao;

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
			activacionDao.save(activacion);
		});

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
	
	@Override
	public Integer countActivacionDia(Integer dia,Integer mes, Integer anio, Long idProducto) {
		return activacionDao.countActivacionDia(dia,mes,anio, idProducto);
	}
	
	
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
