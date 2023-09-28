package com.cata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cata.models.Conexion;
import com.cata.models.Ubicacion;
import com.cata.repositories.ConexionRepository;

@Service
public class ConexionService {
	
	@Autowired
	private ConexionRepository conexionRepository;
	
	public void guardarConexion(Conexion conexion) {
		conexionRepository.save(conexion);
	}
	
	public void actualizarConexion(Conexion conexion) {
		conexionRepository.save(conexion);
	}
	
	public List<Conexion> encontrarTodasConexiones(){
		return conexionRepository.findAll();
	}
	
	public Conexion encontrarConexionId(Long idConexion) {
		return conexionRepository.findById(idConexion).get();
	}
	
	public List<Conexion> encontrarConexionUbicacionO(Ubicacion ubicacion1) {
		return conexionRepository.findByUbicacion1(ubicacion1);
	}
	
	public void eliminarConexion(Long idConexion) {
		conexionRepository.deleteById(idConexion);
	}
	
	public int contarConexiones() {
		return conexionRepository.findAll().size();
	}
	
}
