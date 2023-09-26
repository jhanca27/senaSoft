package com.cata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cata.models.Ubicacion;
import com.cata.services.UbicacionService;


@Controller
@RequestMapping("/Ubicacion")
public class UbicacionControlador {

	@Autowired
	private UbicacionService ubicacionService;
	
	@PostMapping("/save")
	public String save(@ModelAttribute ("ObjUbicacion") Ubicacion ubicacion) {
		ubicacionService.guardarUbicacion(ubicacion);
		return "redirect:/Ubicacion/List";
	}
	
	@PostMapping("/update")
	public String UpDate(@ModelAttribute("ObjUbicacion") Ubicacion ubicacion) {
		ubicacionService.actualizarUbicacion(ubicacion);
		return "redirect:/Ubicacion/List";
	}
	
	@GetMapping("/List")
	public String List(Model model) {
		model.addAttribute(ubicacionService.encontrarTodasUbicaciones());
		return "Ubicaciones";
	}
	
	@GetMapping("/delete/idUbicacion")
	public String delet(@PathVariable ("idUbicacion") Long idUbicacion) {
		ubicacionService.eliminarUbicacion(idUbicacion);
		return "";
	}
	
	
	
	
	
}
