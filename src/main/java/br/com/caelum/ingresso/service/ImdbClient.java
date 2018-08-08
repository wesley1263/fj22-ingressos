package br.com.caelum.ingresso.service;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.model.DetalhesDoFilme;
import br.com.caelum.ingresso.model.Filme;

@Component
public class ImdbClient {

	public Optional<DetalhesDoFilme> request(Filme filme){
		RestTemplate restTemplate = new RestTemplate();
    	
		String url = String.format("http://imdb-fj22.herokuapp.com/imdb?title=%s", filme.getNome());
		
		try {
			DetalhesDoFilme detalhes =  restTemplate.getForObject(url , DetalhesDoFilme.class);
			return Optional.of(detalhes);
		} catch (Exception e) {
			return Optional.empty();
		}
		
    	
	}
}
