package br.com.mateus.springboot2_essentials.util;

import br.com.mateus.springboot2_essentials.domain.Anime;

public class AnimeCreator {
    public static Anime createAnimeToBeSaved() {
        return new Anime(null, "Dragon Ball");
    }
    public static Anime createValidAnime() {
        return new Anime(1L, "Dragon Ball");
    }
    public static Anime createValidUpdatedAnime() {
        return new Anime(1L, "Dragon Ball Z");
    }
}
