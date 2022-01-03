package com.argmoviles.backend.models.dto;

import java.sql.Date;
import java.util.List;

public class VentasProveedorDTO {
	private Date dateFilter;
	private List<Integer> lsprods; //borrar
	
	//
	private List<Integer> lssellers;
	
	//
	private List<Integer> lsnets;
	
	
	public Date getDateFilter() {
		return dateFilter;
	}
	public void setDateFilter(Date dateFilter) {
		this.dateFilter = dateFilter;
	}
	
	public List<Integer> getLsprods() { //borrar
		return lsprods;
	}
	public void setLsprods(List<Integer> lsprods) {//borrar
		this.lsprods = lsprods;
	}
	
	
	//
	public List<Integer> getLsnets() {
		return lsnets;
	}
	public void setLsnets(List<Integer> lsnets) {
		this.lsnets = lsnets;
	}
	//
	public List<Integer> getLssellers() {
		return lssellers;
	}
	//
	public void setLssellers(List<Integer> lssellers) {
		this.lssellers = lssellers;
	}
	
}
