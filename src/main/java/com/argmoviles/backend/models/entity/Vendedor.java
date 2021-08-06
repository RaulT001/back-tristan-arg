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
@Table(name = "vendedores")
public class Vendedor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String ven_nombre;
	private String ven_apellido;
	private int ven_celular;
	private String ven_direccion;

	// @Column(nullable = false, unique = true)
	private int ven_documento;

	private String ven_estado;
	@Temporal(TemporalType.DATE)
	private Date ven_fecha_crea;
	@Temporal(TemporalType.DATE)
	private Date ven_fecha_mod;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedor")
	private List<Activacion> lsActivacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVen_nombre() {
		return ven_nombre;
	}

	public void setVen_nombre(String ven_nombre) {
		this.ven_nombre = ven_nombre;
	}

	public String getVen_apellido() {
		return ven_apellido;
	}

	public void setVen_apellido(String ven_apellido) {
		this.ven_apellido = ven_apellido;
	}

	public int getVen_celular() {
		return ven_celular;
	}

	public void setVen_celular(int ven_celular) {
		this.ven_celular = ven_celular;
	}

	public String getVen_direccion() {
		return ven_direccion;
	}

	public void setVen_direccion(String ven_direccion) {
		this.ven_direccion = ven_direccion;
	}

	public int getVen_documento() {
		return ven_documento;
	}

	public void setVen_documento(int ven_documento) {
		this.ven_documento = ven_documento;
	}

	public String getVen_estado() {
		return ven_estado;
	}

	public void setVen_estado(String ven_estado) {
		this.ven_estado = ven_estado;
	}

	public Date getVen_fecha_crea() {
		return ven_fecha_crea;
	}

	public void setVen_fecha_crea(Date ven_fecha_crea) {
		this.ven_fecha_crea = ven_fecha_crea;
	}

	public Date getVen_fecha_mod() {
		return ven_fecha_mod;
	}

	public void setVen_fecha_mod(Date ven_fecha_mod) {
		this.ven_fecha_mod = ven_fecha_mod;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
