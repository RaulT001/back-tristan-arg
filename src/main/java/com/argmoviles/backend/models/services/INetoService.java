package com.argmoviles.backend.models.services;

import java.util.List;

import com.argmoviles.backend.models.entity.Neto;

public interface INetoService {

	public List<Neto> findAll();
	
	
	public Neto findById(Long id);
	
	public Neto save(Neto neto);
	
	public void delete(Long id);
}
