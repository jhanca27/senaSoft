package com.cata.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cata.models.Ubicacion;
import com.cata.repositories.UbicacionRepository;

@Service
public class UbicacionService {
	
	
	@Autowired
	private UbicacionRepository ubicacionRepository;
	
	public void guardarUbicacion(Ubicacion ubicacion) {
		ubicacionRepository.save(ubicacion);
	}
	
	public void actualizarUbicacion(Ubicacion ubicacion) {
		ubicacionRepository.save(ubicacion);
	}
	
	public List<Ubicacion> encontrarTodasUbicaciones(){
		return ubicacionRepository.findAll();
	}
	
	public Ubicacion encontrarUbicacionId(Long idUbicacion) {
		return ubicacionRepository.findById(idUbicacion).get();
	}
	
	public Ubicacion encontrarUbicacionNombre(String nombre) {
		return ubicacionRepository.findByNombre(nombre).get();
	}
	
	public void eliminarUbicacion(Long idUbicacion) {
		ubicacionRepository.deleteById(idUbicacion);
	}
	
	public int contarUbicaciones() {
		return ubicacionRepository.findAll().size();
	}
	
	public List<String> encontrarListaNombreNodo(){
		List<Ubicacion> listaUbicacion = ubicacionRepository.findAll();
		List<String> listaNombres = new ArrayList<>();
		for(Ubicacion ubicacion:listaUbicacion) {
			listaNombres.add(ubicacion.getNombre());
		}
		return listaNombres;
	}

}
