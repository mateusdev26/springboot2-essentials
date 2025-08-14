package br.com.mateus.springboot2_essentials.mapper;

import br.com.mateus.springboot2_essentials.domain.Anime;
import br.com.mateus.springboot2_essentials.request.AnimePostRequestBody;
import br.com.mateus.springboot2_essentials.request.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);
    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);
    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);
}
