package com.example.musiclib.controllers;

import com.example.musiclib.dto.ArtistDTO;
import com.example.musiclib.entities.Artist;
import com.example.musiclib.services.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/artists")
@RequiredArgsConstructor
public class ArtistController {
    private final ArtistService artistService;

    @GetMapping public List<ArtistDTO> getAll() {
        return artistService.getAll();
    }
    @GetMapping("/{id}") public ArtistDTO getById(@PathVariable Long id) {
        return artistService.getById(id);
    }
    @PostMapping public Artist create(@RequestBody Artist artist) {
        return artistService.save(artist);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArtist(@PathVariable Long id) {
        artistService.delete(id);
        return ResponseEntity.ok("Artist deleted successfully");
    }

}