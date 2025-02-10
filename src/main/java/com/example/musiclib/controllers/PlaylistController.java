package com.example.musiclib.controllers;

import com.example.musiclib.entities.Playlist;
import com.example.musiclib.services.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/playlists")
@RequiredArgsConstructor
public class PlaylistController {
    private final PlaylistService playlistService;

    @GetMapping public List<Playlist> getAll() { return playlistService.getAll(); }
    @GetMapping("/{id}") public Playlist getById(@PathVariable Long id) { return playlistService.getById(id); }
    @PostMapping public Playlist create(@RequestBody Playlist playlist) { return playlistService.save(playlist); }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlaylist(@PathVariable Long id) {
        playlistService.delete(id);
        return ResponseEntity.ok("Playlist deleted successfully");
    }
}