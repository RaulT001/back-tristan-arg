package com.argmoviles.backend.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String usu_nombre;
	private String usu_apellido;
	private int usu_celular;
	private String usu_direccion;

	//@Column(nullable = false, unique = true)
	private int usu_documento;
	private String usu_usuario;
	private String usu_contrasenia;
	private String usu_estado;

	@Temporal(TemporalType.DATE)
	private Date usu_fecha_crea;
	@Temporal(TemporalType.DATE)
	private Date usu_fecha_mod;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsu_nombre() {
		return usu_nombre;
	}

	public void setUsu_nombre(String usu_nombre) {
		this.usu_nombre = usu_nombre;
	}

	public String getUsu_apellido() {
		return usu_apellido;
	}

	public void setUsu_apellido(String usu_apellido) {
		this.usu_apellido = usu_apellido;
	}

	public int getUsu_celular() {
		return usu_celular;
	}

	public void setUsu_celular(int usu_celular) {
		this.usu_celular = usu_celular;
	}

	public String getUsu_direccion() {
		return usu_direccion;
	}

	public void setUsu_direccion(String usu_direccion) {
		this.usu_direccion = usu_direccion;
	}

	public int getUsu_documento() {
		return usu_documento;
	}

	public void setUsu_documento(int usu_documento) {
		this.usu_documento = usu_documento;
	}

	public String getUsu_usuario() {
		return usu_usuario;
	}

	public void setUsu_usuario(String usu_usuario) {
		this.usu_usuario = usu_usuario;
	}

	public String getUsu_contrasenia() {
		return usu_contrasenia;
	}

	public void setUsu_contrasenia(String usu_contrasenia) {
		this.usu_contrasenia = usu_contrasenia;
	}

	public String getUsu_estado() {
		return usu_estado;
	}

	public void setUsu_estado(String usu_estado) {
		this.usu_estado = usu_estado;
	}

	public Date getUsu_fecha_crea() {
		return usu_fecha_crea;
	}

	public void setUsu_fecha_crea(Date usu_fecha_crea) {
		this.usu_fecha_crea = usu_fecha_crea;
	}

	public Date getUsu_fecha_mod() {
		return usu_fecha_mod;
	}

	public void setUsu_fecha_mod(Date usu_fecha_mod) {
		this.usu_fecha_mod = usu_fecha_mod;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
