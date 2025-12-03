package br.com.mateus.springboot2_essentials.client;

import br.com.mateus.springboot2_essentials.domain.Anime;
import br.com.mateus.springboot2_essentials.request.AnimePostRequestBody;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class, 2);
        log.info(entity);
        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class, 2);
        log.info(object);

        Anime[] anime = new RestTemplate().getForObject(
                "http://localhost:8080/animes/all",
                Anime[].class
        );

        log.info(Arrays.toString(anime));

        ResponseEntity<List<Anime>> all = new RestTemplate().exchange(
                "http://localhost:8080/animes/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        log.info(all.getBody());

        AnimePostRequestBody boruto = new AnimePostRequestBody("Boruto");
        Anime savedBoruto = new RestTemplate().postForObject("http://localhost:8080/animes", boruto, Anime.class);
        log.info("Saved anime {}", savedBoruto);

        AnimePostRequestBody dragonball = new AnimePostRequestBody("Dragon Ball");
        ResponseEntity<Anime> savedDragonBall = new RestTemplate().exchange(
                "http://localhost:8080/animes",
                HttpMethod.POST,
                new HttpEntity<>(dragonball,createHttpHeaders()),
                Anime.class
        );
       log.info("Saved anime {}",savedDragonBall);

        Anime animeToBeUpdated = savedDragonBall.getBody();
        animeToBeUpdated.setName("Dragon Ball Z");
        ResponseEntity<Void> savedDragonBallUpdated = new RestTemplate().exchange(
                "http://localhost:8080/animes",
                HttpMethod.PUT,
                new HttpEntity<>(animeToBeUpdated,createHttpHeaders()),
                Void.class
        );
        log.info(savedDragonBallUpdated);

        ResponseEntity<Void> savedDragonBallDelete = new RestTemplate().exchange(
                "http://localhost:8080/animes/{id}",
                HttpMethod.DELETE,
                null,
                Void.class,
                animeToBeUpdated.getId()
        );

        log.info(savedDragonBallDelete);
    }
    private static HttpHeaders createHttpHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
