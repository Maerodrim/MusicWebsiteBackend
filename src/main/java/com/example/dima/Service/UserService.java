package com.example.dima.Service;

import com.example.dima.model.Song;
import com.example.dima.model.User;
import com.example.dima.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final SongService songService;

    @Autowired
    public UserService(UserRepository userRepository, SongService songService) {
        this.userRepository = userRepository;
        this.songService = songService;
    }

    public String addUser(String name, String email, String password) {
        try {
            User user = new User(name, email, password, new HashSet<>());
            userRepository.save(user);

            return "Ok";

        } catch (Exception e) {
            return "Error";
        }
    }

    public String addSongFromUser(String email, String name, String author, String album) {
        try {

            User user = userRepository.findByEmail(email).get(0);
            Set<Song> songs = user.getSongs();
            songs.add(songService.getSong(name, author, album));
            user.setSongs(songs);
            userRepository.save(user);

            return "Ok";

        } catch (Exception e) {
            return "Error";
        }
    }
}
