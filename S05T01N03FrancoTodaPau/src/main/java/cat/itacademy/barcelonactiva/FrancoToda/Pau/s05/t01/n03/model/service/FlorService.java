package cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n03.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;

import cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n03.model.DTO.FlorDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class FlorService {


	private final WebClient client = WebClient.create("http://localhost:9001");



	public ResponseEntity<FlorDTO> add (FlorDTO flor){



		return null;
	}



	public ResponseEntity<FlorDTO> delteteById(Integer id) {




		return null;
	}


	public ResponseEntity<FlorDTO> update(FlorDTO dto) {



		return null;
	}


	public ResponseEntity<List<FlorDTO>> findAll(){



		return null;
	}


	public Optional<FlorDTO> findById(long id){
		ResponseEntity<Optional<FlorDTO>> retorn = null;
		
		System.out.println("ei hola que tal");
		
		WebClient client = WebClient.create("http://localhost:9001");

		UriSpec<RequestBodySpec> uriSpec = client.method(HttpMethod.GET);

		RequestBodySpec bodySpec = uriSpec.uri("/flor/getOne/" + id);

		RequestHeadersSpec<?> headersSpec = bodySpec.bodyValue("data");

		System.err.println("MIRA AQUI PAU PAAAAAAAAAAAAAAAAAAAAAAAAAAAAAU");

		WebClient.ResponseSpec response = headersSpec.retrieve();
		
		System.err.println("BLABLABLABLABALBALBALBALBALBALBALBLABLABLABLAB");
		
		ResponseEntity<Optional> resposta = response.toEntity(Optional.class).block(); // TODO Aixo esta malametn 245% pero almenys no peta
		
		System.out.println(resposta.getBody().toString());
		
		System.err.println("akdnawkdjhakjwdhkajwdhkjawhdkjahwdkjh");
		
//		if (resposta.getStatusCode().equals(HttpStatus.OK)) {
//			
//			
//			retorn = new ResponseEntity<Optional<FlorDTO>>(resposta.getBody() , HttpStatus.OK);
//			
//		} else if (resposta.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
//				
//			retorn = new ResponseEntity<Optional<FlorDTO>>(HttpStatus.NOT_FOUND);
//			
//		} else {
//			System.out.println("Si aico surt per consola el programador es gilipollaaaaAAAAAAAAAaaaaAAAAAs");
//		}
		
		System.err.println("PAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAU");
		
		return resposta.getBody();
	}



	public ResponseEntity<Object> deleteAll() {



		return null;
	}








	public Flux<List<FlorDTO>> getTweetsNonBlocking() {
		
		Flux<List> llista = WebClient.create().get().uri("/sucursal/getAll").retrieve().bodyToFlux(List.class);

//		tweetFlux.subscribe(tweet -> log.info(tweet.toString()));
//		log.info("Exiting NON-BLOCKING Controller!");
//		return tweetFlux;
		
		//llista.fi	
		 return null;
	}

}





















