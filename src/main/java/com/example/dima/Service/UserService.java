package com.example.dima.Service;

import com.example.dima.model.User;
import com.example.dima.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

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

            songService.getSong(name, author, album);

            return "Ok";

        } catch (Exception e) {
            return "Error";
        }
    }
}
