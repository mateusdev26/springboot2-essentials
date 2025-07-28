package br.com.mateus.springboot2_essentials.repository;

import br.com.mateus.springboot2_essentials.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll ();

}
