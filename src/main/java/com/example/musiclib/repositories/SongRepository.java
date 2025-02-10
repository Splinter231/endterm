package com.example.musiclib.repositories;

import com.example.musiclib.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}