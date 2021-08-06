package com.argmoviles.backend.models.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "llamadas")
public class Llamar implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Timestamp llam_fecha_inicio;
	private String llam_deuda;
	private String llam_monto;
	private Timestamp llam_fecha_fin;

	@Temporal(TemporalType.DATE)
	private Date llam_fecha_crea;
	@Temporal(TemporalType.DATE)
	private Date llam_fecha_mod;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id_activacion", nullable = true)
	private Activacion activacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLlam_deuda() {
		return llam_deuda;
	}

	public void setLlam_deuda(String llam_deuda) {
		this.llam_deuda = llam_deuda;
	}

	public String getLlam_monto() {
		return llam_monto;
	}

	public void setLlam_monto(String llam_monto) {
		this.llam_monto = llam_monto;
	}


	public Date getLlam_fecha_crea() {
		return llam_fecha_crea;
	}

	public void setLlam_fecha_crea(Date llam_fecha_crea) {
		this.llam_fecha_crea = llam_fecha_crea;
	}

	public Date getLlam_fecha_mod() {
		return llam_fecha_mod;
	}

	public void setLlam_fecha_mod(Date llam_fecha_mod) {
		this.llam_fecha_mod = llam_fecha_mod;
	}

	public Activacion getActivacion() {
		return activacion;
	}

	public void setActivacion(Activacion activacion) {
		this.activacion = activacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Timestamp getLlam_fecha_inicio() {
		return llam_fecha_inicio;
	}

	public void setLlam_fecha_inicio(Timestamp llam_fecha_inicio) {
		this.llam_fecha_inicio = llam_fecha_inicio;
	}

	public Timestamp getLlam_fecha_fin() {
		return llam_fecha_fin;
	}

	public void setLlam_fecha_fin(Timestamp llam_fecha_fin) {
		this.llam_fecha_fin = llam_fecha_fin;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
