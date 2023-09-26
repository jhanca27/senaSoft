package com.cata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cata.models.Conexion;

@Service
public class RutaServicio {
	@Autowired
	private UbicacionService ubicacionService;
	
	@Autowired
	private ConexionService conexionService;
}
