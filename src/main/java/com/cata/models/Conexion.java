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
	private Ubicacion ubicacion1;
	
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Ubicacion ubicacion2;
	
	public Conexion() {
		// TODO Auto-generated constructor stub
	}

	public Conexion(Long idConexion, @NotNull int peso, Ubicacion ubicacion1, Ubicacion ubicacion2) {
		super();
		this.idConexion = idConexion;
		this.peso = peso;
		this.ubicacion1 = ubicacion1;
		this.ubicacion2 = ubicacion2;
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

	public Ubicacion getUbicacion1() {
		return ubicacion1;
	}

	public void setUbicacion1(Ubicacion ubicacion1) {
		this.ubicacion1 = ubicacion1;
	}

	public Ubicacion getUbicacion2() {
		return ubicacion2;
	}

	public void setUbicacion2(Ubicacion ubicacion2) {
		this.ubicacion2	 = ubicacion2;
	}	
	
}
