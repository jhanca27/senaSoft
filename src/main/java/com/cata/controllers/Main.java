package com.cata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cata.services.RutaServicio;

@Controller
@RequestMapping("/matriz")
public class Main {
	
	@Autowired
	RutaServicio rutaServicio;
	
	@GetMapping("/")
	public String matriz() {
		int matriz[][] = rutaServicio.llenadoMatriz();
		for(int i=0; i<matriz.length; i++) {
			for(int j=0 ; j<matriz.length;j++) {
				System.out.print(matriz[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}
		rutaServicio.DijkstraAlgorithm(matriz, 1, 6);
		return "hola";
	}
}
