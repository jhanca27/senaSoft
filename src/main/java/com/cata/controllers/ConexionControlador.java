package com.cata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cata.models.Conexion;
import com.cata.services.ConexionService;
import com.cata.services.UbicacionService;

@Controller
@RequestMapping("/Conexion")
public class ConexionControlador {

	@Autowired
	private ConexionService conexionService;
	
	@Autowired
	private UbicacionService ubicacionService;
	
	@PostMapping("/save")
	public String save(@ModelAttribute("ObjConexion") Conexion conexion){
		conexionService.guardarConexion(conexion);
		return "redirect:/Conexion/formSave";
	}
	
	@PostMapping("/update/{idConexion}")
	public String upDate(@ModelAttribute ("ObjConexion") Conexion conexion) {
		conexionService.actualizarConexion(conexion);
		return "redirect:/Conexion/List";
	}
	
	@GetMapping("/List")
	public String List(Model model) {
		model.addAttribute(conexionService.encontrarTodasConexiones());
		return "Conexiones";
	}
	
	@GetMapping("/delete/idConexion")
	public String delet(@PathVariable("idConexion") Long idConexion) {
		conexionService.eliminarConexion(idConexion);
		return "Conexiones";
	}
	
	@GetMapping("/formSave")
	public String formSave(Model model) {
		model.addAttribute("ObjConexion", new Conexion());
		model.addAttribute("listUbicaciones", ubicacionService.encontrarTodasUbicaciones());
		return "formCon";
	}
	
}
