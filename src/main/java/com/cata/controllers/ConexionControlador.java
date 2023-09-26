package com.cata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cata.models.Conexion;
import com.cata.services.ConexionService;
import com.cata.services.RutaServicio;

@Controller
@RequestMapping("/Conexion")
public class ConexionControlador {

	@Autowired
	private ConexionService conexionService;
	
	public String save(@ModelAttribute("ObjConexion") Conexion conexion){
		conexionService.guardarConexion(conexion);
		return "redirect:/Conexion/formSave";
	}
	
	public String upDate(@ModelAttribute ("ObjConexion") Conexion conexion) {
		conexionService.actualizarConexion(conexion);
		return "redirect:/Conexion/List";
	}
	
	public String List(Model model) {
		model.addAttribute(conexionService.encontrarTodasConexiones());
		return "Conexiones";
	}
	
	public String delet(@PathVariable("idConexion") Long idConexion) {
		conexionService.eliminarConexion(idConexion);
		return "Conexiones";
	}
	
	public String formSave(Model model) {
		model.addAttribute("ObjConexion", new Conexion());
		return "formCon";
	}
	
}
