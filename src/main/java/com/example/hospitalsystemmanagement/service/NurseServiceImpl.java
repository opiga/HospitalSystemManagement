package com.example.hospitalsystemmanagement.service;

import com.example.hospitalsystemmanagement.entity.Role;
import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.repository.NurseRepository;
import com.example.hospitalsystemmanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by bonda on 01.05.2023 16:45
 *
 * @author bonda
 */
@Service
public class NurseServiceImpl implements NurseService {
    private NurseRepository nurseRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public NurseServiceImpl(NurseRepository theNurseRepository) {
        nurseRepository = theNurseRepository;
    }

    @Override
    public List<User> findAll() {
        return nurseRepository.findAll();
    }

    public User findById(Long theId) {
        Optional<User> result = nurseRepository.findById(theId);
        User theNurse = null;
        if (result.isPresent()) {
            theNurse = result.get();
        }
        else {
            throw new RuntimeException("Did not find nurse id - " + theId);
        }
        return theNurse;
    }

    @Override
        public void save(User theNurse) {
        theNurse.setPassword(bCryptPasswordEncoder.encode(theNurse.getPassword()));
        nurseRepository.save(theNurse);
    }

    @Override
    public void deleteById(Long theId) {
        nurseRepository.deleteById(theId);
    }

}
