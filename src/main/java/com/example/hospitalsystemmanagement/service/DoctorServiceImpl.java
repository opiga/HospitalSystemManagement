package com.example.hospitalsystemmanagement.service;

import com.example.hospitalsystemmanagement.entity.Role;
import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.repository.DoctorRepository;
import com.example.hospitalsystemmanagement.repository.DoctorWithUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by bonda on 17.04.2023 14:50
 *
 * @author bonda
 */
@Service
public class DoctorServiceImpl implements DoctorService {
    private DoctorRepository doctorRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DoctorServiceImpl(DoctorRepository theDoctorRepository) {
        doctorRepository = theDoctorRepository;
    }

    @Override
    public List<User> findAll() {
        return doctorRepository.findAll();
    }


    @Override
    public List<User> findAllNurses() {
        return doctorRepository.findAllNurses();
    }

    @Override
    public List<DoctorWithUsers> findAllWithPatients() {
        return doctorRepository.findAllWithPatients();
    }

    ;

    @Override
    public User findById(Long theId) {
        Optional<User> result = doctorRepository.findById(theId);
        User theDoctor = null;
        if (result.isPresent()) {
            theDoctor = result.get();
        }
        else {
            throw new RuntimeException("Did not find doctor id - " + theId);
        }
        return theDoctor;
    }

    @Override
    public void save(User theDoctor) {
        theDoctor.setPassword(bCryptPasswordEncoder.encode(theDoctor.getPassword()));
        doctorRepository.save(theDoctor);
    }


    @Override
    public void deleteById(Long theId) {
        doctorRepository.deleteById(theId);
    }
}
