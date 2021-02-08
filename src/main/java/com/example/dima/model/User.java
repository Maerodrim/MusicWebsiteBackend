package com.example.dima.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUsers;

    @Column(name = "name", unique = false, nullable = true)
    private String name;

    @Column(name = "email", unique = true, nullable = true)
    private String email;

    @Column(name = "password", unique = false, nullable = true)
    private String password;

    @OneToMany
    @Column(name = "songs", unique = false, nullable = true)
    private Set<Song> songs;

    public User(String name, String email, String password, HashSet<Song> songs) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.songs = songs;
    }
}
