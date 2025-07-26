package br.com.mateus.springboot2.controler;

import br.com.mateus.springboot2.domain.Anime;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("anime")
public class AnimeControler {
  @GetMapping(path = "list")
  public List<Anime> list (){
      return  List.of(
              new Anime("Dragon Ball Super"),
              new Anime("Dragon Ball Z"),
              new Anime("One Piece"),
              new Anime("Death Note"),
              new Anime("Naruto")
      );
  }
}
