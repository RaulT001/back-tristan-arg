package com.argmoviles.backend.models.services;

import com.argmoviles.backend.models.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsurname(String username);
}
