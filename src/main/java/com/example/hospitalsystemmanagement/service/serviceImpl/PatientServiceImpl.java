package com.example.hospitalsystemmanagement.service.serviceImpl;

import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.repository.PatientRepository;
import com.example.hospitalsystemmanagement.repository.PatientWithHospitalCardAndDoctor;
import com.example.hospitalsystemmanagement.repository.PatientWithNumberOpenedHospitalCards;
import com.example.hospitalsystemmanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by bonda on 16.04.2023 20:04
 *
 * @author bonda
 */
@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository thePatientRepository) {
        patientRepository = thePatientRepository;
    }

    @Override
    public List<User> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public User findById(Long theId) {
        Optional<User> result = patientRepository.findById(theId);
        User thePatient = null;
         if (result.isPresent()) {
            thePatient = result.get();
        }
        else {
            throw new RuntimeException("Did not find patient id - " + theId);
        }
        return thePatient;
    }

    @Override
    public void save(User thePatient) {
        patientRepository.save(thePatient);
    }

    @Override
    public void deleteById(Long theId) {
        patientRepository.deleteById(theId);
    }

    @Override
    public List<PatientWithHospitalCardAndDoctor> findAllWithHospitalCardsAndDoctors(){
        return patientRepository.findAllWithHospitalCardsAndDoctors();
    }
    @Override
    public List<PatientWithNumberOpenedHospitalCards> findAllWithNumberOpenedHospitalCards(){
        return patientRepository.findAllWithNumberOpenedHospitalCards();
    }


}
