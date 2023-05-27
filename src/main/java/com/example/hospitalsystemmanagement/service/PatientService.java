package com.example.hospitalsystemmanagement.service;

import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.repository.PatientWithHospitalCardAndDoctor;
import com.example.hospitalsystemmanagement.repository.PatientWithNumberOpenedHospitalCards;

import java.util.List;

/**
 * Created by bonda on 16.04.2023 20:03
 *
 * @author bonda
 */
public interface PatientService {
    public List<User> findAll();

    public User findById(Long theId);

    public void save(User thePatient);

    public void deleteById(Long theId);

    public List<PatientWithHospitalCardAndDoctor> findAllWithHospitalCardsAndDoctors();
    public List<PatientWithNumberOpenedHospitalCards> findAllWithNumberOpenedHospitalCards();
}
