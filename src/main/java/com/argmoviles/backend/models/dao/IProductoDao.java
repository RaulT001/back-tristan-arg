package com.argmoviles.backend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.argmoviles.backend.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long> {

}
