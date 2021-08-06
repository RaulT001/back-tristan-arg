package com.argmoviles.backend.models.services;

import java.util.List;

import com.argmoviles.backend.models.entity.Ingreso;

public interface IIngresoService {
	
	public List<Ingreso> findAll();
	
	public Ingreso findById(Long id);
	
	public Ingreso save(Ingreso ingreso);
	
	public void delete(Long id);
}
