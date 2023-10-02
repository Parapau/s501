package com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.dto.SucursalDTO;
import com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.services.SucursalService;

@Controller
@RequestMapping("/actemele")
public class SucursalWebController {

	@Autowired
	SucursalService service;
	
	
	@GetMapping("/prova")
	public String a (Model model) {

		model.addAttribute("mensaje","blablabla");


		return "hola";
	}
	
	
//	@GetMapping("/prrova")
//	public ResourceBundleMessageSource b (){
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//	    messageSource.setBasename("messages");
//	    return messageSource;
//	}


	@PostMapping("/add")
	public String add (@RequestParam String nom, @RequestParam String pais, Model model){
		SucursalDTO sucursal = service.save(new SucursalDTO(nom, pais));

		model.addAttribute("mensaje", sucursal);
		
		return "hola";
	}
	
	@GetMapping("/delete/{id}")
	public String delete (@PathVariable("id") Integer id, Model model){

		service.deleteById(id);
		
		model.addAttribute("mensaje", "esborrat👍");
		
		return "hola";
	}

	@PostMapping("/update")
	public String update (Model model, @RequestParam Integer id, @RequestParam String nom, @RequestParam String pais){
		Optional<SucursalDTO> sucursalVella = service.findByid(id);
		
		if (sucursalVella.isPresent()) {
			sucursalVella.get().setNomSucursal(nom);
			sucursalVella.get().setPaisSucursal(pais);
			sucursalVella.get().setPk_SucursalID(id);
			service.update(sucursalVella.get());
			model.addAttribute("mensaje", sucursalVella.get()	);
		} else {
			model.addAttribute("mensaje", "No hi ha cap sucursal ambn aquesta id😡");
		}

		

		return "hola";
	}

	@GetMapping("/getOne/{id}")
	public String getOne (Model model, @PathVariable("id") Integer id){
		Optional<SucursalDTO> sucursal = service.findByid(id);
		
//		if (sucursal.isPresent()) {
//			resposta = new ResponseEntity<SucursalDTO>(sucursal.get(), HttpStatus.OK);
//		} else {
//			resposta = new ResponseEntity<SucursalDTO>(HttpStatus.NOT_FOUND);
//		}

		
		model.addAttribute("sucursal", sucursal.get());
		
		return "una";
	}

	@GetMapping("/getAll")
	public String getAll (Model model){
		List<SucursalDTO> resposta = service.findAll();
		
		model.addAttribute("llistaSucursal", resposta);
		
		return "llista";
	}
							
	
	@GetMapping("aTomarPorCulo")
//	@Query("TRUNCATE TABLE sucursal")
	public ResponseEntity<Object> borra(Model model) {
		ResponseEntity<Object> resposta;
		service.deleteAll();
		resposta = new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		
		
		return resposta;
	}



}
