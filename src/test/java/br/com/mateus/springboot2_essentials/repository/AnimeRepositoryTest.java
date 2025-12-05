package br.com.mateus.springboot2_essentials.repository;

import br.com.mateus.springboot2_essentials.domain.Anime;
import jakarta.validation.ConstraintViolationException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Tests for Anime Repository")
class AnimeRepositoryTest {
    @Autowired
    private AnimeRepository repository;

    @Test
    @DisplayName("Saves persists anime when successful")
    void save_PersistAnime_WhenSuccessful() {
        Anime animeToBeSaved = createAnime();
        Anime animeSaved = this.repository.save(animeToBeSaved);
        Assertions.assertThat(animeSaved).isNotNull();
        Assertions.assertThat(animeSaved.getName()).isNotNull();
        Assertions.assertThat(animeSaved.getName()).isEqualTo(animeToBeSaved.getName());
        Assertions.assertThat(animeSaved.getId()).isNotNull();
    }

    @Test
    @DisplayName("Saves updates anime when successful")
    void save_UpdatesAnime_WhenSuccessful() {
        Anime animeToBeSaved = createAnime();
        Anime animeSaved = this.repository.save(animeToBeSaved);
        animeSaved.setName("One piece");
        Anime animeUpdated = this.repository.save(animeSaved);
        Assertions.assertThat(animeUpdated).isNotNull();
        Assertions.assertThat(animeUpdated.getName()).isNotNull();
        Assertions.assertThat(animeUpdated.getName()).isEqualTo(animeSaved.getName());
        Assertions.assertThat(animeUpdated.getId()).isNotNull();
    }

    @Test
    @DisplayName("Delete removes anime when successful")
    void delete_RemovesAnime_WhenSuccessful() {
        Anime animeToBeSaved = createAnime();
        Anime animeSaved = this.repository.save(animeToBeSaved);
        this.repository.delete(animeSaved);
        Optional<Anime> animeOptional = this.repository.findById(animeSaved.getId());
        Assertions.assertThat(animeOptional.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("Find By Name returns list of anime when successful")
    void findByName_ReturnsListOfAnime_WhenSuccessful() {
        Anime animeToBeSaved = createAnime();
        Anime animeSaved = this.repository.save(animeToBeSaved);
        String name = animeSaved.getName();
        List<Anime> animes = this.repository.findByName(name);
        Assertions.assertThat(animes).isNotEmpty()
                .contains(animeSaved);
    }
    @Test
    @DisplayName("Find By Name returns empty list when anime is not found")
    void findByName_ReturnsEmptyList_WhenAnimeIsNotFound(){
        List<Anime> animes = this.repository.findByName("fhgkjrhkjghksjv");
        Assertions.assertThat(animes).isEmpty();
    }
    @Test
    @DisplayName("Save throw ConstraintViolationException when name is empty")
    void save_ThrowConstraintViolationException_WhenNameIsEmpty() {
        Anime anime = new Anime();
        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(()-> this.repository.save(anime))
                .withMessageContaining("The anime name cannot be empty");
    }


    private Anime createAnime() {
        return new Anime(null, "Demon Slayer");
    }
}