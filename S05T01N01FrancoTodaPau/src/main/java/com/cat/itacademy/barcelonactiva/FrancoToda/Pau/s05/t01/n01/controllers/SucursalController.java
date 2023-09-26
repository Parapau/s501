package com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.domain.Sucursal;
import com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.dto.SucursalDTO;
import com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.services.SucursalService;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {

	@Autowired
	SucursalService service;


	@PostMapping("/add")
	public ResponseEntity<SucursalDTO> add (@RequestParam Integer id,  @RequestParam String nom, @RequestParam String pais){
		ResponseEntity<SucursalDTO> resposta = null;
					
		



		return resposta;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete (@PathVariable("id") Integer id){
		ResponseEntity<Object> resposta = null;

		service.deleteById(id);


		return resposta;

	}

	@PutMapping("/update")
	public ResponseEntity<Sucursal> update (){
		ResponseEntity<Sucursal> resposta = null;




		return resposta;
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<Sucursal> getOne (@PathVariable("id") Integer id){
		ResponseEntity<Sucursal> resposta = null;




		return resposta;
	}

	@GetMapping("/getAll")
	public List<ResponseEntity<Sucursal>> getAll (){
		List<ResponseEntity<Sucursal>> resposta = null;




		return resposta;
	}



}
