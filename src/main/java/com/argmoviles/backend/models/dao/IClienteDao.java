package com.argmoviles.backend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.argmoviles.backend.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
