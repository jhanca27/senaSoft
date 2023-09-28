package com.cata.controllers;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cata.models.Conexion;
import com.cata.models.DaoConexion;
import com.cata.models.DataJson;
import com.cata.models.Ubicacion;
import com.cata.repositories.ConexionRepository;
import com.cata.repositories.UbicacionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/Carga")
public class JSONController {
	
	@Autowired
	private UbicacionRepository ubicacionRepository;
	
	@Autowired
	private ConexionRepository conexionRepository;

    @PostMapping("/cargar-json")
    public String cargarJSON(@RequestParam("archivo") MultipartFile archivo) {
        
    	try {
    		ObjectMapper objectMapper = new ObjectMapper();
    		DataJson data = objectMapper.readValue(archivo.getInputStream(), DataJson.class);

            // Procesa la lista de ubicaciones y conexiones
            List<Ubicacion> ubicaciones = data.getUbicaciones();
            
            List<DaoConexion> Daoconexiones = data.getConexiones();
            ubicacionRepository.saveAll(ubicaciones);
            List<Ubicacion> ubicacionesRepo = ubicacionRepository.findAll();
            Conexion ObjConexion = new Conexion();
            for(DaoConexion conexion: Daoconexiones) {
            	for(Ubicacion ubicacion: ubicacionesRepo) {
            		System.out.print(conexion.getUbicacion1());
            		if(conexion.getUbicacion1() == ubicacion.getNombre()) {
            			ObjConexion.setUbicacion1(ubicacion);
            			
            		}
            		System.out.print(ubicacion.getNombre());
            		if(conexion.getUbicacion2() == ubicacion.getNombre()) {
            			ObjConexion.setUbicacion2(ubicacion);
            		}
            	}
            	ObjConexion.setPeso(conexion.getPeso());
            	conexionRepository.save(ObjConexion);
            	ObjConexion = new Conexion();
            }
            //conexionRepository.saveAll(conexiones);
          
            
            return "Archivo JSON cargado correctamente";
        } catch (Exception e) {
            return "Error al cargar el archivo JSON: " + e.getMessage();
        }
    }
}
