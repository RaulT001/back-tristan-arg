package com.argmoviles.backend.models.services;

import java.util.List;

import com.argmoviles.backend.models.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public void delete(Long id);
}
