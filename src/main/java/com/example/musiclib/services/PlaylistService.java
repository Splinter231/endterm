package com.example.musiclib.services;

import com.example.musiclib.entities.Playlist;
import com.example.musiclib.repositories.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public List<Playlist> getAll() { return playlistRepository.findAll(); }
    public Playlist getById(Long id) { return playlistRepository.findById(id).orElseThrow(); }
    public Playlist save(Playlist playlist) { return playlistRepository.save(playlist); }
    public void delete(Long id) { playlistRepository.deleteById(id); }
}