package com.argmoviles.backend.models.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.argmoviles.backend.models.entity.Activacion;

public interface IActivacionDao extends CrudRepository<Activacion, Long> {

	@Query(value = "SELECT * FROM activaciones "
			+ "where act_fecha BETWEEN :dateStart AND :dateEnd", nativeQuery = true)
	public List<Activacion> filterByMonth(@Param("dateStart") Date dateStart,
			@Param("dateEnd") Date dateEnd);

	@Query(value = "SELECT * FROM activaciones "
			+ "where act_fecha = :dateDay", nativeQuery = true)
	public List<Activacion> filterByDay(@Param("dateDay") Date dateDay);

	
	@Query(value = "SELECT count(*) FROM db_arg_backend.activaciones "
			+ "where id_vendedor = :idVendedor AND id_producto = :idProducto "
			+ "AND act_fecha BETWEEN :dateStart AND :dateEnd", nativeQuery = true)
	public Integer countActivacion(@Param("idVendedor") Long idVendedor,
			@Param("idProducto") Long idProducto, @Param("dateStart") Date dateStart,
			@Param("dateEnd") Date dateEnd);

	
	//borrar
	@Query(value = "SELECT count(*) FROM db_arg_backend.activaciones "
			+ "where DAY(act_fecha) =  :dia and MONTH(act_fecha)= :mes and YEAR(act_fecha) = :anio"
			+ " AND id_producto = :idProducto", nativeQuery = true)
	public Integer countActivacionDia(@Param("dia") Integer dia,@Param("mes") Integer mes,@Param("anio") Integer anio,
			@Param("idProducto") Long idProducto);
	
	
	
	
	//ventas x día de Neto
	@Query(value = "SELECT count(*) FROM db_arg_backend.activaciones "
			+ "where DAY(act_fecha) =  :dia and MONTH(act_fecha)= :mes and YEAR(act_fecha) = :anio"
			+ " AND id_neto = :idNeto", nativeQuery = true)
	public Integer countActivacionDiaNeto(@Param("dia") Integer dia,@Param("mes") Integer mes,@Param("anio") Integer anio,
			@Param("idNeto") Long idNeto);
	
	

	
	
	
	@Query(value = "SELECT * FROM db_arg_backend.activaciones where act_importe = :val", nativeQuery = true)
	public List<Activacion> filterByColumnImporte(@Param("val") int val);
	
	@Query(value = "SELECT * FROM db_arg_backend.activaciones where act_saldo = :val", nativeQuery = true)
	public List<Activacion> filterByColumnSaldo(@Param("val") int val);
	
	@Query(value = "SELECT * FROM db_arg_backend.activaciones where act_inicial = :val", nativeQuery = true)
	public List<Activacion> filterByColumnInicial(@Param("val") int val);
	
	@Query(value = "SELECT * FROM db_arg_backend.activaciones where act_tipo = :val", nativeQuery = true)
	public List<Activacion> filterByColumnTipo(@Param("val") String val);
	
	@Query(value = "SELECT * FROM db_arg_backend.activaciones where act_factura = :val", nativeQuery = true)
	public List<Activacion> filterByColumn(@Param("val") String val);

	@Query(value = "SELECT * FROM db_arg_backend.activaciones where act_utilizacion = :val", nativeQuery = true)
	public List<Activacion> filterByColumnUtilizacion(@Param("val") String val);
	
	@Query(value = "SELECT * FROM db_arg_backend.activaciones where act_cuota = :val", nativeQuery = true)
	public List<Activacion> filterByColumnCuota(@Param("val") int val);
	
	@Query(value = "SELECT * FROM db_arg_backend.activaciones where act_modalidad = :val", nativeQuery = true)
	public List<Activacion> filterByColumnModalidad(@Param("val") String val);
	
	
	@Query(value = "SELECT * FROM db_arg_backend.activaciones where id_producto= :id", nativeQuery = true)
	public List<Activacion> getColummsbyProducto(@Param("id") Long val);
	
	@Query(value = "SELECT * FROM db_arg_backend.activaciones where id_ingreso= :id", nativeQuery = true)
	public List<Activacion> getColummsbyIngreso(@Param("id") Long val);
	
	@Query(value = "SELECT * FROM db_arg_backend.activaciones where id_vendedor= :id", nativeQuery = true)
	public List<Activacion> getColummsbyVendedor(@Param("id") Long val);
	
	@Query(value = "SELECT * FROM db_arg_backend.activaciones where id_neto= :id", nativeQuery = true)
	public List<Activacion> getColummsbyNeto(@Param("id") Long val);
	
}
