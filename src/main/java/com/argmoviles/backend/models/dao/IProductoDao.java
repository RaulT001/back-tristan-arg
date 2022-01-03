package com.argmoviles.backend.models.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.argmoviles.backend.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long> {
	
	@Query(value = "SELECT * FROM productos "
			+ "where prod_nombre like :nombre", nativeQuery = true)
	public Producto findProductByName(@Param("nombre") String nombre);

}
