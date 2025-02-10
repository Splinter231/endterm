package com.example.musiclib.services;

import com.example.musiclib.entities.Playlist;
import com.example.musiclib.repositories.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public List<Playlist> getAll() {
        return playlistRepository.findAll();
    }

    public Playlist getById(Long id) {
        return playlistRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Playlist not found"));
    }

    public Playlist save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public void delete(Long id) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));

        playlist.getSongs().clear();
        playlistRepository.delete(playlist);
    }

}