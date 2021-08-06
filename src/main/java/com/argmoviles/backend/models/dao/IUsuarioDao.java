package com.argmoviles.backend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.argmoviles.backend.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

}
