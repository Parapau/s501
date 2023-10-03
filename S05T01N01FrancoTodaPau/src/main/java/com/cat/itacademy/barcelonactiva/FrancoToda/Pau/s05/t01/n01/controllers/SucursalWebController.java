package com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
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


		return "index";
	}
	
	
	
	@GetMapping("/add")
    public String showUserForm(Model model){
        model.addAttribute("sucursal", new SucursalDTO());
        return "sucursalForm";
    }
	
	
	@GetMapping("/index")
	public String index(String index) {//es string perque no peti si algu escriu algo al input
		String retorn;
	
		switch(index.charAt(0)) {
		case '1':
			retorn = "add";
			break;
		case '2':
			retorn = "getOne";
			break;
		case '3':
			retorn = "getAll";
			break;
		case '4':
			retorn = "update";
			break;
		case '5':
			retorn = "delete";
			break;
		case '6':
			retorn = "aTomarPorCulo";
			break;
		default:
			retorn = "tonto";
			break;
		}
		
		
		return retorn;
	}
	
	@GetMapping("/menu")
	public String menu() {
				
		return "index";
	}
	
	
	

	@PostMapping("/create")
	 public ModelAndView createUser(SucursalDTO sucursal) {
        ModelAndView model = new ModelAndView();
        model.addObject("sucursal", sucursal);
        sucursal.tipejar();
        
        sucursal = service.save(sucursal);
        
        model.setViewName("sucursal"); 
        
        return model;
    }
	

//	@PostMapping("/add")
//	public String add (@RequestParam String nom, @RequestParam String pais, Model model){
//		SucursalDTO sucursal = service.save(new SucursalDTO(nom, pais));
//
//		model.addAttribute("mensaje", sucursal);
//		
//		return "hola";
//	}
	
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
