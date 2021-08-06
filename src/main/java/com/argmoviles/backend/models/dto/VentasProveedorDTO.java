package com.argmoviles.backend.models.dto;

import java.sql.Date;
import java.util.List;

public class VentasProveedorDTO {
	private Date dateFilter;
	private List<Integer> lsprods;
	private List<Integer> lssellers;
	
	
	public Date getDateFilter() {
		return dateFilter;
	}
	public void setDateFilter(Date dateFilter) {
		this.dateFilter = dateFilter;
	}
	public List<Integer> getLsprods() {
		return lsprods;
	}
	public void setLsprods(List<Integer> lsprods) {
		this.lsprods = lsprods;
	}
	public List<Integer> getLssellers() {
		return lssellers;
	}
	public void setLssellers(List<Integer> lssellers) {
		this.lssellers = lssellers;
	}
	
	
	
}
