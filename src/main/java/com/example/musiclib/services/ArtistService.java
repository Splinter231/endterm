package com.example.musiclib.services;

import com.example.musiclib.dto.ArtistDTO;
import com.example.musiclib.entities.Artist;
import com.example.musiclib.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArtistService {
    private final ArtistRepository artistRepository;

    public List<ArtistDTO> getAll() {
        return artistRepository.findAll().stream()
                .map(artist -> new ArtistDTO(artist.getId(), artist.getName(), artist.getGenre()))
                .collect(Collectors.toList());
    }

    public ArtistDTO getById(Long id) {
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found"));
        return new ArtistDTO(artist.getId(), artist.getName(), artist.getGenre());
    }

    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    public void delete(Long id) {
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found"));


        artistRepository.deleteById(id);
        artistRepository.save(artist);
    }
}
