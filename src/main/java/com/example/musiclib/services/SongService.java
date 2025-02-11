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
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final PlaylistRepository playlistRepository;

    public List<Song> getAll() { return songRepository.findAll(); }
    public Song getById(Long id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Song not found"));
    }

    public Song save(Song song, Long artistId) {
        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Artist not found"));
        song.setArtist(artist);
        return songRepository.save(song);
    }

    public void delete(Long id) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Song not found"));

        song.getPlaylists().forEach(playlist -> playlist.getSongs().remove(song));
        songRepository.delete(song);
    }


    public void addSongToPlaylist(Long songId, Long playlistId) {
        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new RuntimeException("Song not found"));
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));

        playlist.getSongs().add(song);
        playlistRepository.save(playlist);
    }
}