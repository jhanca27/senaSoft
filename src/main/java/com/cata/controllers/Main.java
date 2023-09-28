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
		
		rutaServicio.DijkstraAlgorithm(matriz, 0, 2);
		
		return "hola";
	}
}
