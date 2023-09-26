package com.cata.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ubicaciones")
public class Ubicacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUbicacion;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private int posX;
	
	@NotNull
	private int posY;

	public Ubicacion() {
		// TODO Auto-generated constructor stub
	}
	
	public Ubicacion(Long idUbicacion, @NotNull String nombre, @NotNull int posX, @NotNull int posY) {
		super();
		this.idUbicacion = idUbicacion;
		this.nombre = nombre;
		this.posX = posX;
		this.posY = posY;
	}

	public Long getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(Long idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
	
	
}
