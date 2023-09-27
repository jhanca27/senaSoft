package com.cata.services;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.data.util.Predicates;
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
		int matrizPeso[][] = new int[tamanoUbicacion][tamanoUbicacion]; //matriz adyacencia
		
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
		
		return Integer.MAX_VALUE;
		
	}
	
	
	public void DijkstraAlgorithm(int[][] matriz, int source, int destination) {
			
		int n = matriz.length;
		int[] distancias = new int[n];
		Integer[] rutas = new Integer[n];
		int contador = 0;
		int[][] matrizOperacion = matriz;
		List<Integer> listaPesos = new ArrayList<>();
		List<List<Integer>> listaRuta = new ArrayList<>();
		int refi = 0;
		int refj = 0;
		int pesoTotal = 0;
		
		
		for(int i=source; i < n; i++) {
			int minDistance = Integer.MAX_VALUE;
			for(int j = 0 ; j < n ;j++) {
				if(refi == j && refj ==i) {
					 continue;
				  }
				if(matrizOperacion[i][j] != 0 && matrizOperacion[i][j] < minDistance ) {
				  distancias[contador] = matriz[i][j];
				  rutas[contador] = j;
				  contador += 1;
				  refi = i;
				  refj = j;
				  i = j-1;
				  
				 
				  if(destination-1 == j) {
					  matrizOperacion[refi][refj] = Integer.MAX_VALUE; 
					  
					  //listaPesos.add(Arrays.asList(distancias).stream().mapToInt(Integer::intValue).sum());
					  pesoTotal = Arrays.stream(distancias).parallel().reduce(0,(a,b)->  a + b);
					  listaPesos.add(pesoTotal);
					  List<Integer> lista = new ArrayList<Integer>(Arrays.asList(rutas));
					  while (lista.remove(null)) {}
					  listaRuta.add(lista);	
					  distancias = new int[n];
					  rutas = new Integer[n];
					  
					  i = source;
					  j = -1;
					  contador = 0;
					  break;
				  }
				  
				  break;
				}
				if(i == 0 && j == destination-1) {
					i=n;
				}
				if(i!=0 && i!= n && j == n-1){
					matriz[refi][refj] = Integer.MAX_VALUE;
					i = source;
					contador=0;
				}
			}		
		}
		
		System.out.print(listaPesos);
		System.out.print(listaRuta);
		
	}
	
	
	

		
	
	
}
