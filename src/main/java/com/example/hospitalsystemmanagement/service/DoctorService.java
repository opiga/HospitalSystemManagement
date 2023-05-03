package com.example.hospitalsystemmanagement.service;

import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.repository.DoctorWithUsers;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by bonda on 17.04.2023 14:49
 *
 * @author bonda
 */
public interface DoctorService {

    public List<User> findAll();

    public List<DoctorWithUsers> findAllWithPatients();

    public User findById(Long theId);

    public void save(User theDoctor);

    public void deleteById(Long theId);
}
