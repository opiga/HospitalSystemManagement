package com.example.hospitalsystemmanagement.service.serviceImpl;

import com.example.hospitalsystemmanagement.entity.Appointment;
import com.example.hospitalsystemmanagement.entity.HospitalCard;
import com.example.hospitalsystemmanagement.entity.User;
import com.example.hospitalsystemmanagement.repository.AppointmentRepository;
import com.example.hospitalsystemmanagement.repository.HospitalCardRepository;
import com.example.hospitalsystemmanagement.repository.NurseRepository;
import com.example.hospitalsystemmanagement.service.NurseService;
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
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    private HospitalCardRepository hospitalCardRepository;
    private AppointmentRepository appointmentRepository;
    private NurseRepository nurseRepository;


    @Autowired
    public NurseServiceImpl(NurseRepository theNurseRepository,
                            HospitalCardRepository theHospitalCardRepository,
                            AppointmentRepository theAppointmentRepository) {
        nurseRepository = theNurseRepository;
        hospitalCardRepository = theHospitalCardRepository;
        appointmentRepository = theAppointmentRepository;

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
        Optional<User> optionalNurse = nurseRepository.findById(theId);
        if (optionalNurse.isPresent()) {
            User nurse = optionalNurse.get();
            List<HospitalCard> hospitalCards = hospitalCardRepository.findAllByNurseId(nurse.getId());
            for (HospitalCard hospitalCard : hospitalCards) {
                List<Appointment> appointments = appointmentRepository.findAllByHospitalCardId(hospitalCard.getHospitalCardId());
                for (Appointment appointment : appointments) {
                    if (appointment.getNurse().getId() == nurse.getId()) {
                        appointment.setNurse(null);
                    }
                }
                hospitalCard.setNurse(null);
                hospitalCardRepository.save(hospitalCard);
            }
            nurseRepository.deleteById(nurse.getId());
        }

    }

}
