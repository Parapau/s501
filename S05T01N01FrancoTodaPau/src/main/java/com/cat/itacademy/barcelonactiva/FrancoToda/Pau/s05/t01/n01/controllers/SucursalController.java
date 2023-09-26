package com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.dto.SucursalDTO;
import com.cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n01.model.services.SucursalService;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {

	@Autowired
	SucursalService service;


	@PostMapping("/add")
	public ResponseEntity<SucursalDTO> add (@RequestParam String nom, @RequestParam String pais){
		ResponseEntity<SucursalDTO> resposta;
					
		SucursalDTO sucursal = service.save(new SucursalDTO(nom, pais));

		resposta = new ResponseEntity<SucursalDTO>(sucursal, HttpStatus.CREATED);

		return resposta;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete (@PathVariable("id") Integer id){
		ResponseEntity<Object> resposta;

		service.deleteById(id);
		
		resposta = new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		
		return resposta;
	}

	@PutMapping("/update")
	public ResponseEntity<SucursalDTO> update (@RequestParam Integer id, @RequestParam String nom, @RequestParam String pais){
		ResponseEntity<SucursalDTO> resposta;
		SucursalDTO sucursal;
		Optional<SucursalDTO> sucursalVella = service.findByid(id);
		
		if (sucursalVella.isPresent()) {
			sucursalVella.get().setNomSucursal(nom);
			sucursalVella.get().setPaisSucursal(pais);
			service.save(sucursalVella.get());
			resposta = new ResponseEntity<SucursalDTO>(sucursalVella.get(), HttpStatus.OK);
		} else {
			resposta = new ResponseEntity<SucursalDTO>(HttpStatus.NOT_FOUND);
		}


		return resposta;
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<SucursalDTO> getOne (@PathVariable("id") Integer id){
		ResponseEntity<SucursalDTO> resposta = null;
		Optional<SucursalDTO> sucursal = service.findByid(id);
		
		if (sucursal.isPresent()) {
			resposta = new ResponseEntity<SucursalDTO>(sucursal.get(), HttpStatus.OK);
		} else {
			resposta = new ResponseEntity<SucursalDTO>(HttpStatus.NOT_FOUND);
		}

		return resposta;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<SucursalDTO>> getAll (){
		ResponseEntity<List<SucursalDTO>> resposta = new ResponseEntity<List<SucursalDTO>>(service.findAll(), HttpStatus.OK);

		return resposta;
	}



}
