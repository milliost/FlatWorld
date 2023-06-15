package com.example.servingwebcontent.service;

import com.example.servingwebcontent.entity.User;

import java.util.List;


public interface UserService {
    void saveUser(User user);

    User findUserByEmail(String email);

    List<User> findAllUsers();
}
