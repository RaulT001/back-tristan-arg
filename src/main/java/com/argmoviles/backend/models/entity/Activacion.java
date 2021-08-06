package com.argmoviles.backend.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "activaciones")
public class Activacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int act_numero_sec;
	private String act_cliente;
	private String act_celular;
	private int act_importe;
	private int act_saldo;
	private int act_inicial;
	private String act_tipo;
	private String act_factura;

	@Temporal(TemporalType.DATE)
	private Date act_fecha;
	private String act_sap;
	private String act_utilizacion;
	private int act_cuota;
	private String act_moneda;

	private Date act_ciclo;
	private String act_neto;
	private String act_mayor_noventa;

	private String act_estado;
	@Temporal(TemporalType.DATE)
	private Date act_fecha_crea;
	@Temporal(TemporalType.DATE)
	private Date act_fecha_mod;

	// borrar
	private String opcionpro;
	// private String vendedor;
	private String ciclofac;
	private String dias;
	private String comentario;

	private String act_ingreso;
	private String act_modalidad;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hipernateLazyInitializer", "handler" })
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_vendedor", nullable = true)
	private Vendedor vendedor;

	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = true)
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = true)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "id_neto", nullable = true)
	private Neto neto;

	@ManyToOne
	@JoinColumn(name = "id_ingreso", nullable = true)
	private Ingreso ingreso;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "activacion")
	private List<Llamar> lsLlamar;

	public Ingreso getIngreso() {
		return ingreso;
	}

	public void setIngreso(Ingreso ingreso) {
		this.ingreso = ingreso;
	}

	public Date getAct_fecha() {
		return act_fecha;
	}

	public void setAct_fecha(Date act_fecha) {
		this.act_fecha = act_fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setAct_celular(String act_celular) {
		this.act_celular = act_celular;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAct_numero_sec() {
		return act_numero_sec;
	}

	public void setAct_numero_sec(int act_numero_sec) {
		this.act_numero_sec = act_numero_sec;
	}

	public String getAct_cliente() {
		return act_cliente;
	}

	public void setAct_cliente(String act_cliente) {
		this.act_cliente = act_cliente;
	}

	public String getAct_celular() {
		return act_celular;
	}

	public int getAct_importe() {
		return act_importe;
	}

	public void setAct_importe(int act_importe) {
		this.act_importe = act_importe;
	}

	public int getAct_saldo() {
		return act_saldo;
	}

	public void setAct_saldo(int act_saldo) {
		this.act_saldo = act_saldo;
	}

	public int getAct_inicial() {
		return act_inicial;
	}

	public void setAct_inicial(int act_inicial) {
		this.act_inicial = act_inicial;
	}

	public String getAct_tipo() {
		return act_tipo;
	}

	public void setAct_tipo(String act_tipo) {
		this.act_tipo = act_tipo;
	}

	public String getAct_factura() {
		return act_factura;
	}

	public void setAct_factura(String act_factura) {
		this.act_factura = act_factura;
	}

	public String getAct_sap() {
		return act_sap;
	}

	public void setAct_sap(String act_sap) {
		this.act_sap = act_sap;
	}

	public String getAct_utilizacion() {
		return act_utilizacion;
	}

	public void setAct_utilizacion(String act_utilizacion) {
		this.act_utilizacion = act_utilizacion;
	}

	public int getAct_cuota() {
		return act_cuota;
	}

	public void setAct_cuota(int act_cuota) {
		this.act_cuota = act_cuota;
	}

	public String getAct_moneda() {
		return act_moneda;
	}

	public void setAct_moneda(String act_moneda) {
		this.act_moneda = act_moneda;
	}

	public Date getAct_ciclo() {
		return act_ciclo;
	}

	public void setAct_ciclo(Date act_ciclo) {
		this.act_ciclo = act_ciclo;
	}

	public String getAct_neto() {
		return act_neto;
	}

	public void setAct_neto(String act_neto) {
		this.act_neto = act_neto;
	}

	public String getAct_mayor_noventa() {
		return act_mayor_noventa;
	}

	public void setAct_mayor_noventa(String act_mayor_noventa) {
		this.act_mayor_noventa = act_mayor_noventa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAct_estado() {
		return act_estado;
	}

	public void setAct_estado(String act_estado) {
		this.act_estado = act_estado;
	}

	public Date getAct_fecha_crea() {
		return act_fecha_crea;
	}

	public void setAct_fecha_crea(Date act_fecha_crea) {
		this.act_fecha_crea = act_fecha_crea;
	}

	public Date getAct_fecha_mod() {
		return act_fecha_mod;
	}

	public void setAct_fecha_mod(Date act_fecha_mod) {
		this.act_fecha_mod = act_fecha_mod;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getCiclofac() {
		return ciclofac;
	}

	public void setCiclofac(String ciclofac) {
		this.ciclofac = ciclofac;
	}

	public String getOpcionpro() {
		return opcionpro;
	}

	public void setOpcionpro(String opcionpro) {
		this.opcionpro = opcionpro;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Neto getNeto() {
		return neto;
	}

	public void setNeto(Neto neto) {
		this.neto = neto;
	}

	public List<Llamar> getLsLlamar() {
		return lsLlamar;
	}

	public void setLsLlamar(List<Llamar> lsLlamar) {
		this.lsLlamar = lsLlamar;
	}

	public String getAct_ingreso() {
		return act_ingreso;
	}

	public void setAct_ingreso(String act_ingreso) {
		this.act_ingreso = act_ingreso;
	}

	public String getAct_modalidad() {
		return act_modalidad;
	}

	public void setAct_modalidad(String act_modalidad) {
		this.act_modalidad = act_modalidad;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
