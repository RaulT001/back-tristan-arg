package com.argmoviles.backend.models.services;

import java.util.List;

import com.argmoviles.backend.models.entity.Vendedor;

	public interface IVendedorService {
	
	public List<Vendedor> findAll();
	
	public Vendedor findById(Long id);
	
	public Vendedor save(Vendedor vendedor);
	
	public void delete(Long id);
	
}
