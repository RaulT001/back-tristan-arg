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
@Table(name = "clientes")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cli_nombre;
	private String cli_apellido;
	private String cli_celular;
	private String cli_direccion;
	private String cli_documento;
	private Date cli_fecha;
	private String cli_estado;

	@Temporal(TemporalType.DATE)
	private Date cli_fecha_crea;
	@Temporal(TemporalType.DATE)
	private Date cli_fecha_mod;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<Activacion> lsActivacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCli_nombre() {
		return cli_nombre;
	}

	public void setCli_nombre(String cli_nombre) {
		this.cli_nombre = cli_nombre;
	}

	public String getCli_apellido() {
		return cli_apellido;
	}

	public void setCli_apellido(String cli_apellido) {
		this.cli_apellido = cli_apellido;
	}

	public String getCli_celular() {
		return cli_celular;
	}

	public void setCli_celular(String cli_celular) {
		this.cli_celular = cli_celular;
	}

	public String getCli_direccion() {
		return cli_direccion;
	}

	public void setCli_direccion(String cli_direccion) {
		this.cli_direccion = cli_direccion;
	}

	public String getCli_documento() {
		return cli_documento;
	}

	public void setCli_documento(String cli_documento) {
		this.cli_documento = cli_documento;
	}

	public Date getCli_fecha() {
		return cli_fecha;
	}

	public void setCli_fecha(Date cli_fecha) {
		this.cli_fecha = cli_fecha;
	}

	public String getCli_estado() {
		return cli_estado;
	}

	public void setCli_estado(String cli_estado) {
		this.cli_estado = cli_estado;
	}

	public Date getCli_fecha_crea() {
		return cli_fecha_crea;
	}

	public void setCli_fecha_crea(Date cli_fecha_crea) {
		this.cli_fecha_crea = cli_fecha_crea;
	}

	public Date getCli_fecha_mod() {
		return cli_fecha_mod;
	}

	public void setCli_fecha_mod(Date cli_fecha_mod) {
		this.cli_fecha_mod = cli_fecha_mod;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
