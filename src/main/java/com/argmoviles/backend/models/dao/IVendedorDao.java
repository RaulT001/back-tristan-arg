package com.argmoviles.backend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.argmoviles.backend.models.entity.Vendedor;

public interface IVendedorDao extends CrudRepository<Vendedor, Long> {

}
