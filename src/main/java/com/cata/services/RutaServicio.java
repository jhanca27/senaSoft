package com.cata.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cata.models.Conexion;
import com.cata.models.Ubicacion;



@Service
public class RutaServicio {
	
	private UbicacionService ubicacionService;
	
	private ConexionService conexionService;
	
	
	public RutaServicio(UbicacionService ubicacionService, ConexionService conexionService) {
		this.ubicacionService = ubicacionService;
		this.conexionService = conexionService;
	}
	
	
	
	
	public int[][] llenadoMatriz() {
		int tamanoUbicacion = ubicacionService.contarUbicaciones();
		int tamanoPesos = conexionService.contarConexiones();
		int matrizPeso[][] = new int[tamanoUbicacion][tamanoUbicacion]; //matriz adyacencia
		List<Ubicacion> listaNodos = ubicacionService.encontrarTodasUbicaciones();
		
		List<String> listaNombreNodos = ubicacionService.encontrarListaNombreNodo();
		
		for(int i=0; i < tamanoUbicacion; i++) {
			for(int j=0 ; j < tamanoUbicacion;j++) {
				Ubicacion ubicacionActual = ubicacionService.encontrarUbicacionNombre(listaNombreNodos.get(i));
				if(i == j) {
					matrizPeso[i][j] = 0;
				}else {
					if(matrizPeso[i][j] == 0) {
						matrizPeso[i][j] = match(ubicacionActual,listaNombreNodos.get(j),listaNombreNodos.get(i));
						matrizPeso[j][i] = matrizPeso[i][j] ;
					}
						
					
				}
				
			}
			
		}
		return matrizPeso;
		
	}
	
	public int match(Ubicacion ubicacionActual,String nodoO,String nodoT) {
			List<Conexion> listaConexiones = conexionService.encontrarConexionUbicacionO(ubicacionActual);
			for(Conexion conexion:listaConexiones) {
				if(conexion.getUbicacionT().getNombre() == nodoO ) {
					return conexion.getPeso();
				}
			}	
		
		return 0;
		
	}

		
	
	
}
