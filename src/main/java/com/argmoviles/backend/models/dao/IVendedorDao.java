package com.argmoviles.backend.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.argmoviles.backend.models.entity.Vendedor;

public interface IVendedorDao extends CrudRepository<Vendedor, Long> {

	
	@Query(value = "SELECT * FROM vendedores "
			+ "where ven_nombre like :nombre", nativeQuery = true)
	public Vendedor findVendedorByName(@Param("nombre") String nombre);
}
