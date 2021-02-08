package com.example.dima.controller;

import com.example.dima.Service.SongService;
import com.example.dima.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping("/addSong")
    public String addSong(@RequestParam String name, @RequestParam String pathToIcon,
                          @RequestParam String pathToSong, @RequestParam String author, @RequestParam String album) {
        return songService.addSong(name, pathToIcon, pathToSong, author, album);
    }

    @GetMapping("/getSongs")
    public Set<Song> getSongs(@RequestParam String name, @RequestParam String author, @RequestParam String album) {
        return songService.getSongs(name, author, album);
    }

    @GetMapping("/getSong")
    public Song getSong(@RequestParam String name, @RequestParam String author, @RequestParam String album) {
        return songService.getSong(name, author, album);
    }
}

