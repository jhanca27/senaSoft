package com.cata.models;

public class DaoConexion {

	private int peso;
	private String ubicacion1;
	private String ubicacion2;
	
	public DaoConexion() {
		// TODO Auto-generated constructor stub
	}

	public DaoConexion(int peso, String ubicacion1, String ubicacion2) {
		super();
		this.peso = peso;
		this.ubicacion1 = ubicacion1;
		this.ubicacion2 = ubicacion2;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getUbicacion1() {
		return ubicacion1;
	}

	public void setUbicacion1(String ubicacion1) {
		this.ubicacion1 = ubicacion1;
	}

	public String getUbicacion2() {
		return ubicacion2;
	}

	public void setUbicacion2(String ubicacion2) {
		this.ubicacion2 = ubicacion2;
	}

	
	
	
}
