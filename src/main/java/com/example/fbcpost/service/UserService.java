package com.example.fbcpost.service;

import com.example.fbcpost.domain.User;
import com.example.fbcpost.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    public User findUserByUserName(String id) {
        return usersRepository.findByUserName(id).get();
    }

    public User findUserById(String id) {
        return usersRepository.findById(id).get();
    }

    public User saveUser(User user) {
        return usersRepository.save(user);
    }
}
