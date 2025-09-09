package br.com.mateus.springboot2_essentials.service;

import br.com.mateus.springboot2_essentials.domain.Anime;
import br.com.mateus.springboot2_essentials.exception.BadRequestException;
import br.com.mateus.springboot2_essentials.mapper.AnimeMapper;
import br.com.mateus.springboot2_essentials.repository.AnimeRepository;
import br.com.mateus.springboot2_essentials.request.AnimePostRequestBody;
import br.com.mateus.springboot2_essentials.request.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AnimeService {
    private final AnimeRepository animeRepository;

    public List<Anime> listAll() {
        return animeRepository.findAll();
    }
    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        return listAll()
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Anime not found"));
    }
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePostRequestBody);
        return animeRepository.save(anime);
    }

    public void delete(long id) {
        animeRepository.deleteById(id);
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime newAnime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        animeRepository.delete(savedAnime);
        animeRepository.save(newAnime);
    }
}
