package br.com.caelum.ingresso.service;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.model.DetalhesDoFilme;
import br.com.caelum.ingresso.model.Filme;

@Component
public class ImdbClient {

	public <T>Optional<T> request(Filme filme, Class<T> classe){
		RestTemplate restTemplate = new RestTemplate();
    	
		String url = String.format("http://imdb-fj22.herokuapp.com/imdb?title=%s", filme.getNome());
		
		try {
			T detalhes =  restTemplate.getForObject(url , classe);
			return Optional.of(detalhes);
		} catch (Exception e) {
			return Optional.empty();
		}
		
    	
	}
}
