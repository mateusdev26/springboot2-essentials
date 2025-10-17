package br.com.mateus.springboot2_essentials.service;

import br.com.mateus.springboot2_essentials.domain.Anime;
import br.com.mateus.springboot2_essentials.exception.BadRequestException;
import br.com.mateus.springboot2_essentials.mapper.AnimeMapper;
import br.com.mateus.springboot2_essentials.repository.AnimeRepository;
import br.com.mateus.springboot2_essentials.request.AnimePostRequestBody;
import br.com.mateus.springboot2_essentials.request.AnimePutRequestBody;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Log4j2
@Service
@RequiredArgsConstructor
public class AnimeService {
    private final AnimeRepository animeRepository;
    public Page<Anime> listAll(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }
    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime not found"));
    }
    @Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        log.info("Anime post request body : "+animePostRequestBody);
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePostRequestBody);
        log.info("Anime : "+ anime);
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
