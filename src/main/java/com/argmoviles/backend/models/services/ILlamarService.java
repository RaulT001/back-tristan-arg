package com.argmoviles.backend.models.services;

import java.util.List;

import com.argmoviles.backend.models.entity.Llamar;

public interface ILlamarService {
	
	public List<Llamar> findAll();
	
	public Llamar findById(Long id);
	
	public Llamar save(Llamar llamar);
	
	public Llamar update(Llamar llamar);
	
	public void delete(Long id);
}
