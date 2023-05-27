package com.example.hospitalsystemmanagement.service;

import com.example.hospitalsystemmanagement.entity.Appointment;

import java.util.List;

/**
 * Created by bonda on 17.04.2023 14:49
 *
 * @author bonda
 */
public interface AppointmentService {

    public List<Appointment> findAll();

    List<Appointment> findAllAppointedByHospitalCardId(Long id);

    public Appointment findById(Long theId);

    public void save(Appointment appointment);

    public void deleteById(Long theId);

    public List<Appointment> findAllByHospitalCardId(Long id);
}
