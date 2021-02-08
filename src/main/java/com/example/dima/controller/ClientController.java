package com.example.dima.controller;

import com.example.dima.Service.UserService;
import com.example.dima.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public ClientController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        return userService.addUser(name, email, password);
    }
    @PostMapping("/addSongFromUser")
    public String addSongFromUser(@RequestParam String email, @RequestParam String name, @RequestParam String author, @RequestParam String album) {
        return userService.addSongFromUser(email, name, author, album);
    }

    @GetMapping("/getPassword")
    public Boolean getPassword(@RequestParam String email, @RequestParam String password) {
        return userRepository.findByEmail(email).get(0).getPassword().equals(password);
    }
}
