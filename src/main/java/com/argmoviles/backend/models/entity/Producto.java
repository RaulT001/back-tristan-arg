package com.argmoviles.backend.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String prod_nombre;
	private String prod_descripcion;
	private int prod_precio;

	private String prod_estado;
	@Temporal(TemporalType.DATE)
	private Date prod_fecha_crea;
	@Temporal(TemporalType.DATE)
	private Date prod_fecha_mod;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
	private List<Activacion> lsActivacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProd_nombre() {
		return prod_nombre;
	}

	public void setProd_nombre(String prod_nombre) {
		this.prod_nombre = prod_nombre;
	}

	public String getProd_descripcion() {
		return prod_descripcion;
	}

	public void setProd_descripcion(String prod_descripcion) {
		this.prod_descripcion = prod_descripcion;
	}

	public int getProd_precio() {
		return prod_precio;
	}

	public void setProd_precio(int prod_precio) {
		this.prod_precio = prod_precio;
	}

	public String getProd_estado() {
		return prod_estado;
	}

	public void setProd_estado(String prod_estado) {
		this.prod_estado = prod_estado;
	}

	public Date getProd_fecha_crea() {
		return prod_fecha_crea;
	}

	public void setProd_fecha_crea(Date prod_fecha_crea) {
		this.prod_fecha_crea = prod_fecha_crea;
	}

	public Date getProd_fecha_mod() {
		return prod_fecha_mod;
	}

	public void setProd_fecha_mod(Date prod_fecha_mod) {
		this.prod_fecha_mod = prod_fecha_mod;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
