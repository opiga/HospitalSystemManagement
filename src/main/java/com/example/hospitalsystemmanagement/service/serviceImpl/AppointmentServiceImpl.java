package com.example.hospitalsystemmanagement.service.serviceImpl;
import com.example.hospitalsystemmanagement.entity.Appointment;
import com.example.hospitalsystemmanagement.repository.AppointmentRepository;
import com.example.hospitalsystemmanagement.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by bonda on 05.05.2023 13:05
 *
 * @author bonda
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository theAppointmentRepository) {
        appointmentRepository = theAppointmentRepository;
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> findAllAppointedByHospitalCardId(Long id){
        return appointmentRepository.findAllAppointedByHospitalCardId(id);
    }
    @Override
    public List<Appointment> findAllByHospitalCardId(Long id){
        return appointmentRepository.findAllByHospitalCardId(id);
    }

    @Override
    public Appointment findById(Long theId) {
        Optional<Appointment> result = appointmentRepository.findById(theId);
        Appointment theAppointment = null;
        if (result.isPresent()) {
            theAppointment = result.get();
        }
        else {
            throw new RuntimeException("Did not find appointment id - " + theId);
        }
        return theAppointment;
    }

    @Override
    public void save(Appointment theAppointment) {
        appointmentRepository.save(theAppointment);
    }

    @Override
    public void deleteById(Long theId) {
        appointmentRepository.deleteById(theId);
    }
}