package com.argmoviles.backend.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "netos")
public class Neto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String net_pro;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "neto")
	private List<Activacion> lsActivacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNet_pro() {
		return net_pro;
	}

	public void setNet_pro(String net_pro) {
		this.net_pro = net_pro;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
