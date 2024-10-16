package com.example.fbcpost.controller;

import com.example.fbcpost.domain.User;
import com.example.fbcpost.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fbc/post")
@CrossOrigin({"*"})
public class UsersController {

    List<String> users=new ArrayList<>(
            Arrays.asList("aden mohamed ali","maryan mohamed ali","abdullahi mohamed","salah farah","farah ali"));

    @Autowired
    UsersRepository usersRepository;
    @PostMapping("/")
    public User saveUser(@RequestBody User user) {

        user.setId(UUID.randomUUID().toString());

        return usersRepository.save(user);
    }

    @GetMapping("/{searchValue}")
    public List<User> getUser(@PathVariable String searchValue) {

        List<User> users1=usersRepository.findAll();

        return users1.stream().filter(e->e.getFirstName().contains(searchValue) || e.getLastName().contains(searchValue)).
                collect(Collectors.toUnmodifiableList());
    }
}
