package br.com.mateus.springboot2.controler;

import br.com.mateus.springboot2.domain.Anime;
import br.com.mateus.springboot2.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("anime")
@AllArgsConstructor
public class AnimeControler {
   private DateUtil dateUtil ;
  @GetMapping(path = "list")
  public List<Anime> list (){
      log.info(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
      return  List.of(
              new Anime("Dragon Ball Super"),
              new Anime("Dragon Ball Z"),
              new Anime("One Piece"),
              new Anime("Death Note"),
              new Anime("Naruto")
      );
  }
}
