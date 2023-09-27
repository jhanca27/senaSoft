package com.cata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Principal")
public class PrincipalControlador {

	@GetMapping("/")
	public String home() {
		return "Principal";
	}
	
}
