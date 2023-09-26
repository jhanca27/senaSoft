package com.cata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cata.models.Conexion;
import com.cata.models.Ubicacion;



@Service
public class RutaServicio {
	
	@Autowired
	private UbicacionService ubicacionService;
	
	@Autowired
	private ConexionService conexionService;
	
	
	int tamanoUbicacion = ubicacionService.contarUbicaciones();
	int tamanoPesos = conexionService.contarConexiones();
	int matrizPeso[][] = new int[tamanoUbicacion][tamanoUbicacion]; //matriz adyacencia
	List<Ubicacion> listaNodos = ubicacionService.encontrarTodasUbicaciones();  // arreglo nodos
	List<String> listaNombreNodos = ubicacionService.encontrarListaNombreNodo();
	
	public void llenadoMatriz() {
		
		for(int i=0; i<tamanoUbicacion; i++) {
			for(int j=0 ; j<tamanoUbicacion;i++) {
				if(i == j) {
					matrizPeso[i][j] = 0;
				}else {
					matrizPeso[i][j] = match(listaNodos,listaNombreNodos.get(j));
				}
				
			}
		}
		
	}
	
	public int match(List<Ubicacion> listaUbicacion,String nodo) {
		for(Ubicacion ubicacion:listaUbicacion) {
			List<Conexion> listaConexiones = conexionService.encontrarConexionUbicacionO(ubicacion);
			for(Conexion conexion:listaConexiones) {
				if(conexion.getUbicacionT().getNombre() == nodo ) {
					return conexion.getPeso();
				}
			}	
		}
		return 0;
		
	}
		
}
