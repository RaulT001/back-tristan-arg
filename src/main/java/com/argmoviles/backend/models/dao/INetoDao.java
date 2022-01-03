package com.argmoviles.backend.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.argmoviles.backend.models.entity.Neto;

public interface INetoDao extends CrudRepository<Neto, Long> {

	
	@Query(value = "SELECT * FROM netos "
			+ "where net_pro like :nombre", nativeQuery = true)
	public Neto findNetoByName(@Param("nombre") String nombre);
}
