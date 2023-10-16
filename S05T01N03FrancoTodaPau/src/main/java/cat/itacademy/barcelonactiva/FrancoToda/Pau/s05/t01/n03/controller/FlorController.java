package cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n03.controller;

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
import org.springframework.web.reactive.function.client.WebClient;

import cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n03.model.DTO.FlorDTO;
import cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n03.model.service.FlorService;


@RestController
@RequestMapping("/flor")
public class FlorController {


	@Autowired
	FlorService service;


	@GetMapping("/lala")
	public String lala () {
		return "lalalalalalalal aixo funciona be lalalalalalalal";
	}


	@GetMapping("/getOne/{id}")
	public ResponseEntity<FlorDTO> getOne (@PathVariable("id") long id){
		ResponseEntity<FlorDTO> resposta = null;
		Optional<FlorDTO> flor = service.findById(id);
		if (flor.isPresent()) {
			resposta = new ResponseEntity<FlorDTO>(flor.get(), HttpStatus.OK);
		} else {
			resposta = new ResponseEntity<FlorDTO>(HttpStatus.NOT_FOUND);
		}

		return resposta;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<FlorDTO>> getAll (){

		ResponseEntity<List<FlorDTO>> retorn = new ResponseEntity<List<FlorDTO>>(service.findAll(), HttpStatus.OK);

		return retorn;
	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") long id){
		ResponseEntity<Object> resposta = service.delteteById(id);

		return resposta;

	}

	@PostMapping("/add")
	public ResponseEntity<FlorDTO> add(@RequestParam String nom, @RequestParam String pais){
		ResponseEntity<FlorDTO> retorn = new ResponseEntity<FlorDTO>(service.add(new FlorDTO(nom, pais)), HttpStatus.OK);

		return retorn;
	}



	@PutMapping("/update")
	public ResponseEntity<FlorDTO> update(@RequestParam long id, @RequestParam String nom, @RequestParam String pais){
		ResponseEntity<FlorDTO> retorn;
		if (service.findById(id).isPresent()) {
			System.err.println("no queiro dormir");
			retorn = new ResponseEntity<FlorDTO>(service.update(new FlorDTO(id, nom, pais)), HttpStatus.OK);
		} else {
			System.err.println("que bien");
			retorn = new ResponseEntity<FlorDTO>(HttpStatus.NOT_FOUND);
		}
		return retorn;
	}


	@DeleteMapping("/borra")
	public ResponseEntity<String> deleteAll(){
		service.deleteAll();
		return new ResponseEntity<String>("Tot esborrat :)", HttpStatus.NO_CONTENT);
	}


}




























































