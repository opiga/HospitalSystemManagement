package com.example.hospitalsystemmanagement.repository;

import com.example.hospitalsystemmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);



}
