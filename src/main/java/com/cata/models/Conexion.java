package com.cata.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "conexiones")
public class Conexion {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConexion;
	
	@NotNull
	private int peso;
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Ubicacion ubicacionO;
	
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Ubicacion ubicacionT;
	
	public Conexion() {
		// TODO Auto-generated constructor stub
	}

	public Conexion(Long idConexion, @NotNull int peso, Ubicacion ubicacionO, Ubicacion ubicacionT) {
		super();
		this.idConexion = idConexion;
		this.peso = peso;
		this.ubicacionO = ubicacionO;
		this.ubicacionT = ubicacionT;
	}

	public Long getIdConexion() {
		return idConexion;
	}

	public void setIdConexion(Long idConexion) {
		this.idConexion = idConexion;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Ubicacion getUbicacionO() {
		return ubicacionO;
	}

	public void setUbicacionO(Ubicacion ubicacionO) {
		this.ubicacionO = ubicacionO;
	}

	public Ubicacion getUbicacionT() {
		return ubicacionT;
	}

	public void setUbicacionT(Ubicacion ubicacionT) {
		this.ubicacionT = ubicacionT;
	}	
	
}
