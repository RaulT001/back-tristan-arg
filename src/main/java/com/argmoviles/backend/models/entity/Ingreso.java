package com.argmoviles.backend.models.entity;

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
@Table(name = "ingresos")
public class Ingreso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String ingr_nombre;
	private String ingr_apellido;

	private String ingr_estado;
	@Temporal(TemporalType.DATE)
	private Date ingr_fecha_crea;
	@Temporal(TemporalType.DATE)
	private Date ingr_fecha_mod;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ingreso")
	private List<Activacion> lsActivacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIngr_nombre() {
		return ingr_nombre;
	}

	public void setIngr_nombre(String ingr_nombre) {
		this.ingr_nombre = ingr_nombre;
	}

	public String getIngr_apellido() {
		return ingr_apellido;
	}

	public void setIngr_apellido(String ingr_apellido) {
		this.ingr_apellido = ingr_apellido;
	}

	public String getIngr_estado() {
		return ingr_estado;
	}

	public void setIngr_estado(String ingr_estado) {
		this.ingr_estado = ingr_estado;
	}

	public Date getIngr_fecha_crea() {
		return ingr_fecha_crea;
	}

	public void setIngr_fecha_crea(Date ingr_fecha_crea) {
		this.ingr_fecha_crea = ingr_fecha_crea;
	}

	public Date getIngr_fecha_mod() {
		return ingr_fecha_mod;
	}

	public void setIngr_fecha_mod(Date ingr_fecha_mod) {
		this.ingr_fecha_mod = ingr_fecha_mod;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
