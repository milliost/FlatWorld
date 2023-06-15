package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
