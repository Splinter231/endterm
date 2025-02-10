package com.example.musiclib.services;

import com.example.musiclib.entities.Song;
import com.example.musiclib.entities.Artist;
import com.example.musiclib.repositories.PlaylistRepository;
import com.example.musiclib.entities.Playlist;
import com.example.musiclib.repositories.SongRepository;
import com.example.musiclib.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final PlaylistRepository playlistRepository;

    public List<Song> getAll() { return songRepository.findAll(); }
    public Song getById(Long id) { return songRepository.findById(id).orElseThrow(); }

    public Song save(Song song, Long artistId) {
        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new RuntimeException("Artist not found"));
        song.setArtist(artist);
        return songRepository.save(song);
    }

    public void delete(Long id) { songRepository.deleteById(id); }

    public void addSongToPlaylist(Long songId, Long playlistId) {
        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new RuntimeException("Song not found"));
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));

        playlist.getSongs().add(song);
        playlistRepository.save(playlist);
    }
}