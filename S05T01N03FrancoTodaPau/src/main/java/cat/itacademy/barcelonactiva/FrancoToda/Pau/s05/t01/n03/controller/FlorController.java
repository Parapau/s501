package cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n03.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
		System.err.println("locolocolocolocolocodondequiera");
		Optional<FlorDTO> flor = service.findById(id).getBody();
		System.err.println("Aixo es el controlador, estic controlant");
		if (flor.isPresent()) {
			System.err.println("e");
			System.out.println(flor.get().toString());
			resposta = new ResponseEntity<FlorDTO>(flor.get(), HttpStatus.OK);
			System.err.println("eee");
		} else {
			resposta = new ResponseEntity<FlorDTO>(HttpStatus.NOT_FOUND);
		}
		
		System.err.println("iniminmainimo");
		
		return resposta;
	}
	
	
}
