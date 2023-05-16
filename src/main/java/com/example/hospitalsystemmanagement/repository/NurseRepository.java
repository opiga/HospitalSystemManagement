package com.example.hospitalsystemmanagement.repository;

import com.example.hospitalsystemmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by bonda on 15.05.2023 13:11
 *
 * @author bonda
 */
public interface NurseRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users where users.role_Id=(Select roles.id from roles where roles.role_Name='nurse')", nativeQuery = true)
    public List<User> findAll();







}
