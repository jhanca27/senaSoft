package com.cata.models;

import java.util.List;

public class DataJson {
	
	  private List<Ubicacion> ubicaciones;
	  private List<DaoConexion> conexiones;
	  private String inicio;
	  
	  
	  
	  public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public DataJson(String inicio) {
		super();
		this.inicio = inicio;
	}

	public DataJson() {
		// TODO Auto-generated constructor stub
	}

	public DataJson(List<Ubicacion> ubicaciones, List<DaoConexion> conexiones) {
		super();
		this.ubicaciones = ubicaciones;
		this.conexiones = conexiones;
	}

	public List<Ubicacion> getUbicaciones() {
		return ubicaciones;
	}

	public void setUbicaciones(List<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public List<DaoConexion> getConexiones() {
		return conexiones;
	}

	public void setConexiones(List<DaoConexion> conexiones) {
		this.conexiones = conexiones;
	}  

}
