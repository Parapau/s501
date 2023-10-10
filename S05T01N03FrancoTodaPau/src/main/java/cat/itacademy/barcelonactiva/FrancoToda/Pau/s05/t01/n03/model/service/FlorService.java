package cat.itacademy.barcelonactiva.FrancoToda.Pau.s05.t01.n03.model.service;

import org.springframework.web.reactive.function.client.WebClient;

public class FlorService {


	private final WebClient client = WebClient.create("http://localhost:9001");
	
	public FlorDTO save(FlorDTO dto) {
		
	}
	
}
