package com.argmoviles.backend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.argmoviles.backend.models.entity.Llamar;

public interface ILlamarDao extends CrudRepository<Llamar, Long> {

}
