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
import org.springframework.web.reactive.function.client.WebClientResponseException;

import cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n03.model.DTO.FlorDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class FlorService {

	private final static WebClient client = WebClient.create("http://localhost:9001");



	public FlorDTO add (FlorDTO dto){
		System.err.println("okokokokokokokokokokokokokokokok");
		UriSpec<RequestBodySpec> uriSpec = client.method(HttpMethod.POST);
		RequestBodySpec bodySpec = uriSpec.uri("/flor/add?" + dto.getNomSucursal() + "&" + dto.getPaisSucursal());
		RequestHeadersSpec<?> headersSpec = bodySpec.bodyValue(dto);
		FlorDTO retorn = headersSpec.retrieve().bodyToMono(FlorDTO.class).block();
		
		return retorn;
	}



	public ResponseEntity<Object> delteteById(long id) {
		ResponseEntity<Object> retorn = null;
		
		UriSpec<RequestBodySpec> uriSpec = client.method(HttpMethod.DELETE);

		RequestBodySpec bodySpec = uriSpec.uri("/flor/delete/" + id);
		
		retorn = bodySpec.retrieve().toEntity(Object.class).block();
		
		System.err.println(retorn.getStatusCode());
		
		return retorn;
	}


	public FlorDTO update(FlorDTO dto) {
		
//		UriSpec<RequestBodySpec> uriSpec = client.method(HttpMethod.PUT);
//
//		RequestBodySpec bodySpec = uriSpec.uri("/flor/getOne?" + dto.getPk_SucursalID() + "&" + dto.getNomSucursal() + "&" + dto.getPaisSucursal());
//
//		RequestHeadersSpec<?> headersSpec = bodySpec.bodyValue("data");
//
//		FlorDTO resposta = headersSpec.retrieve().bodyToMono(FlorDTO.class).block();
//
//		return resposta;
		
		
		UriSpec<RequestBodySpec> uriSpec = client.method(HttpMethod.PUT);
		RequestBodySpec bodySpec = uriSpec.uri("/flor/update?id=" + dto.getPk_SucursalID() + "&nom=" + dto.getNomSucursal() + "&pais" + dto.getPaisSucursal());
		RequestHeadersSpec<?> headersSpec = bodySpec.bodyValue(dto);
		FlorDTO retorn = headersSpec.retrieve().bodyToMono(FlorDTO.class).block();
		
		return retorn;
	}


	public List<FlorDTO> findAll(){

		UriSpec<RequestBodySpec> uriSpec = client.method(HttpMethod.GET);

		RequestBodySpec bodySpec = uriSpec.uri("/flor/getAll");

		RequestHeadersSpec<?> headersSpec = bodySpec.bodyValue("data");

		List<FlorDTO> resposta = headersSpec.retrieve().bodyToFlux(FlorDTO.class).collectList().block();

		return resposta;
	}


	public Optional<FlorDTO> findById(long id){
		
		UriSpec<RequestBodySpec> uriSpec = client.method(HttpMethod.GET);

		RequestBodySpec bodySpec = uriSpec.uri("/flor/getOne/" + id);

		RequestHeadersSpec<?> headersSpec = bodySpec.bodyValue("data");

		Optional<FlorDTO> resposta = headersSpec.retrieve().bodyToMono(FlorDTO.class).blockOptional();

		return resposta;


	}



	public void deleteAll() {

		UriSpec<RequestBodySpec> uriSpec = client.method(HttpMethod.DELETE);

		RequestBodySpec bodySpec = uriSpec.uri("/flor/aTomarPorCulo");
	}

}





















