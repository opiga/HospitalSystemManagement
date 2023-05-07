package com.example.hospitalsystemmanagement.service;

import com.example.hospitalsystemmanagement.entity.HospitalCard;
import com.example.hospitalsystemmanagement.repository.HospitalCardRepository;
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
public class HospitalCardServiceImpl implements HospitalCardService {

    private HospitalCardRepository hospitalCardRepository;

    @Autowired
    public HospitalCardServiceImpl(HospitalCardRepository theHospitalCardRepository) {
        hospitalCardRepository = theHospitalCardRepository;
    }

    @Override
    public List<HospitalCard> findAllByPatientId(Long id) {
        return hospitalCardRepository.findAllByPatientId(id);
    }

    @Override
    public List<HospitalCard> findAllByDoctorId(Long id) {
        return hospitalCardRepository.findAllByDoctorId(id);
    }

    @Override
    public HospitalCard findById(Long theId) {
        Optional<HospitalCard> result = hospitalCardRepository.findById(theId);
        HospitalCard theHospitalCard = null;
        if (result.isPresent()) {
            theHospitalCard = result.get();
        }
        else {
            throw new RuntimeException("Did not find HospitalCard id - " + theId);
        }
        return theHospitalCard;
    }

    @Override
    public void save(HospitalCard thePatient) {
        hospitalCardRepository.save(thePatient);
    }

    @Override
    public void deleteById(Long theId) {
        hospitalCardRepository.deleteById(theId);
    }

}
