package br.com.mateus.springboot2_essentials.repository;

import br.com.mateus.springboot2_essentials.domain.Anime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@DisplayName("Tests for Anime Repository")
class AnimeRepositoryTest {
    @Autowired 
    private AnimeRepository repository;

    @Test
    @DisplayName("Saves creates anime when successful")
    void save_PersistAnime_WhenSuccessful(){
       Anime animeToBeSaved = createAnime();
       Anime animeSaved = this.repository.save(animeToBeSaved);
       Assertions.assertThat(animeSaved).isNotNull();
       Assertions.assertThat(animeSaved.getName()).isNotNull();
       Assertions.assertThat(animeSaved.getName()).isEqualTo(animeToBeSaved.getName());
       Assertions.assertThat(animeSaved.getId()).isNotNull();
    }
    private Anime createAnime(){
        return new Anime(null,"Demon Slayer");
    }
}