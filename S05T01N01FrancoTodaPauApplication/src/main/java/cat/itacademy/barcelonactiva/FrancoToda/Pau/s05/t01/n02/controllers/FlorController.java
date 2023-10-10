package cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n02.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n02.model.services.FlorService;

@RestController
@RequestMapping("/flor")
public class FlorController {

	@Autowired
	FlorService service;

	
	@GetMapping("/")
	public String patata () {
		return "El sever funciona :)  👍";
	}
	

	@PostMapping("/add")
	public ResponseEntity<FlorDTO> add (@RequestParam String nom, @RequestParam String pais){
		ResponseEntity<FlorDTO> resposta;	
		FlorDTO sucursal = service.save(new FlorDTO(nom, pais));
		
		
		
		resposta = new ResponseEntity<FlorDTO>(sucursal, HttpStatus.CREATED);

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
	public ResponseEntity<FlorDTO> update (@RequestParam Integer id, @RequestParam String nom, @RequestParam String pais){
		ResponseEntity<FlorDTO> resposta;
		FlorDTO sucursal;
		Optional<FlorDTO> sucursalVella = service.findByid(id);
		
		if (sucursalVella.isPresent()) {
			sucursalVella.get().setNomSucursal(nom);
			sucursalVella.get().setPaisSucursal(pais);
			service.save(sucursalVella.get());
			resposta = new ResponseEntity<FlorDTO>(sucursalVella.get(), HttpStatus.OK);
		} else {
			resposta = new ResponseEntity<FlorDTO>(HttpStatus.NOT_FOUND);
		}


		return resposta;
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<FlorDTO> getOne (@PathVariable("id") Integer id){
		ResponseEntity<FlorDTO> resposta = null;
		Optional<FlorDTO> sucursal = service.findByid(id);
		
		if (sucursal.isPresent()) {
			resposta = new ResponseEntity<FlorDTO>(sucursal.get(), HttpStatus.OK);
		} else {
			resposta = new ResponseEntity<FlorDTO>(HttpStatus.NOT_FOUND);
		}

		return resposta;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<FlorDTO>> getAll (){
		ResponseEntity<List<FlorDTO>> resposta = new ResponseEntity<List<FlorDTO>>(service.findAll(), HttpStatus.OK);

		return resposta;
	}

	
	@GetMapping("aTomarPorCulo")
	//@Query("TRUNCATE TABLE sucursal")
	public ResponseEntity<Object> borra() {
		ResponseEntity<Object> resposta;
		service.deleteAll();
		resposta = new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		
		return resposta;
	}


}
