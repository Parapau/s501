package com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sucursal")
public class SucursalWebController {
	
	
	@GetMapping("/prova")
	public String a (Model model) {
		
		model.addAttribute("mensaje","blablabla");
		
		
		return "Hola";
	}
	
	

}
