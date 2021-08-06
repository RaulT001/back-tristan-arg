package com.argmoviles.backend.models.services;

import java.util.List;

import com.argmoviles.backend.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	
	public Producto findById(Long id);
	
	public Producto save(Producto producto);
	
	public void delete(Long id);
}
