package com.cata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cata.services.UpLoadFileService;

@Controller
@RequestMapping("/Carga")
public class UpLoadFileController {

	@Autowired
	private UpLoadFileService uploadService;
	
	@GetMapping("/form")
	public String formCarga() {
		return "UpLoadFileJSON";
	}
	
	@GetMapping("/")
	public String carga(@PathVariable ("archivos") MultipartFile file) {
		uploadService.SaveJson(file);
		return "redirect:/Ubicacion/formSave";
	}
	
	
}
