package com.example.dima.Service;

import com.example.dima.model.Song;
import com.example.dima.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SongService {
    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public String addSong(String name, String pathToIcon, String pathToSong, String author, String album) {
        try {
            Song song = new Song(name, pathToIcon, pathToSong, author, album);
            songRepository.save(song);
            return "Ok";

        } catch (Exception e) {
            return "Error";
        }
    }

    public Set<Song> getSongs(String name, String author, String album) {
        Set<Song> songs = new HashSet<Song>();
        if (!name.isEmpty()) {
            songs.addAll(songRepository.findByNameAfter(name));
        }
        if (!author.isEmpty()) {
            songs.addAll(songRepository.findByAuthorAfter(author));
        }
        if (!album.isEmpty()) {
            songs.addAll(songRepository.findByAlbumAfter(album));
        }
        return songs;
    }

    public Set<Song> getSong(String name, String author, String album) {
        return new HashSet<Song>() {{
            addAll(songRepository.findByNameAndAlbumAndAuthor(name, author, album));
        }};
    }
}
