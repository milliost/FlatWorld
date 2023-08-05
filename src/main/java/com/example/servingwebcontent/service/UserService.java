package com.example.servingwebcontent.service;

import com.example.servingwebcontent.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void saveUser(User user);

    User findUserByEmail(String email);

    User findByName(String name);
    void addWin();

    List<User> findAllUsers();
}
