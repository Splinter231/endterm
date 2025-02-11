package com.example.musiclib.controllers;

import com.example.musiclib.entities.Song;
import com.example.musiclib.services.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongController {
    private final SongService songService;

    @GetMapping public List<Song> getAll() {
        return songService.getAll();
    }
    @GetMapping("/{id}") public Song getById(@PathVariable Long id) {
        return songService.getById(id);
    }
    @PostMapping("/{artistId}") public Song create(@RequestBody Song song, @PathVariable Long artistId) {
        return songService.save(song, artistId);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSong(@PathVariable Long id) {
        songService.delete(id);
        return ResponseEntity.ok("Song deleted successfully");
    }
    @PostMapping("/{playlistId}/add-song/{songId}")
    public void addSongToPlaylist(@PathVariable Long playlistId, @PathVariable Long songId) {
        songService.addSongToPlaylist(songId, playlistId);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable Long id, @RequestBody Song updatedSong) {
        Song song = songService.updateSong(id, updatedSong);
        return ResponseEntity.ok(song);
    }

}