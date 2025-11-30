package br.com.mateus.springboot2_essentials.client;

import br.com.mateus.springboot2_essentials.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> forEntity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class,2);
        log.info(forEntity);
        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class,2);
        log.info(object);
    }
}
