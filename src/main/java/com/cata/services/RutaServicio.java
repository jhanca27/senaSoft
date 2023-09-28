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
		boolean valor = false;
		
		
		for(int i=source; i < n; i++) {
			int minDistance = Integer.MAX_VALUE;
			for(int j = 0 ; j < n ;j++) {
				if(refi == j && refj ==i) {
					if(j==n-1) {
						matrizOperacion[i][j] = -matrizOperacion[i][j];
						matrizOperacion[j][i] = -matrizOperacion[j][i];
						distancias = new int[n];
						rutas = new Integer[n];
		
					}	
					 continue;
				  }
				if(matrizOperacion[i][j] != 0 && matrizOperacion[i][j] < minDistance && j!=source && matrizOperacion[i][j]>0 ) {
				  distancias[contador] = matrizOperacion[i][j];
				  rutas[contador] = j;
				  contador += 1;
				  refi = i;
				  refj = j;
				  i = j-1;
				 
				  if(destination-1 == j) {
					  matrizOperacion[refi][refj] = -matrizOperacion[refi][refj]; 
					  pesoTotal = Arrays.stream(distancias).parallel().reduce(0,(a,b)->  a + b);
					  listaPesos.add(pesoTotal);
					  List<Integer> lista = new ArrayList<Integer>(Arrays.asList(rutas));
					  while (lista.remove(null)) {}
					  listaRuta.add(lista);	
					  distancias = new int[n];
					  rutas = new Integer[n];
					  
					  i = source-1;
					  j = -1;
					  contador = 0;
					  break;
				  }
				  
				  break;
				}
				if(i == source && j == n-1) {
					i=n;
					break;
				}
				if(i!=source && j == n-1){
					matrizOperacion[refi][refj] = -matrizOperacion[refi][refj];
					if(refi == source) {
						matrizOperacion[refj][refi] = Integer.MAX_VALUE;
						for(int q = 0; q<n;q++) {
							for(int r = 0; r<n;r++) {
								if(q != source && matrizOperacion[q][r]<0) {
										matrizOperacion[q][r]= -matrizOperacion[q][r];
								}
							}
						}
					}
					i = source-1;
					contador=0;
					distancias = new int[n];
					rutas = new Integer[n];
					
				}
			}		
		}
		
		System.out.print(listaPesos);
		System.out.print(listaRuta);
		
	}
	
	
	

		
	
	
}
