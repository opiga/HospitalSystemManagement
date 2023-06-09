package com.example.hospitalsystemmanagement.service;

import com.example.hospitalsystemmanagement.entity.User;

import java.util.List;

/**
 * Created by bonda on 16.04.2023 20:03
 *
 * @author bonda
 */
public interface NurseService {
    public List<User> findAll();

    public void save(User theNurse);

    public User findById(Long theId);
    public void deleteById(Long theId);
}
