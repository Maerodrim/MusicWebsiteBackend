package com.example.dima.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idSong;

    @Column(name = "name", unique = false, nullable = true)
    private String name;

    @Column(name = "pathToIcon", unique = false, nullable = true)
    private String pathToIcon;

    @Column(name = "pathToSong", unique = false, nullable = true)
    private String pathToSong;

    @Column(name = "author", unique = false, nullable = true)
    private String author;

    @Column(name = "album", unique = false, nullable = true)
    private String album;


    public Song(String name, String pathToIcon, String pathToSong, String author, String album) {
        this.name = name;
        this.pathToIcon = pathToIcon;
        this.pathToSong = pathToSong;
        this.author = author;
        this.album = album;
    }
}
