package com.argmoviles.backend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.argmoviles.backend.models.entity.Ingreso;

public interface IIngresoDao extends CrudRepository<Ingreso, Long> {

}
