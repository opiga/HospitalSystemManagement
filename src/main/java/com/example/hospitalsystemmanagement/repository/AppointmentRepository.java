package com.example.hospitalsystemmanagement.repository;

import com.example.hospitalsystemmanagement.entity.Appointment;
import com.example.hospitalsystemmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by bonda on 16.04.2023 20:05
 *
 * @author bonda
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query(value = "SELECT * FROM appointments as a where a.hospital_Card_Id=? and a.status='appointed'", nativeQuery = true)
    public List<Appointment> findAllAppointedByHospitalCardId(Long id);
    @Query(value = "SELECT * FROM appointments as a where a.hospital_Card_Id=?", nativeQuery = true)
    public List<Appointment> findAllByHospitalCardId(Long id);
}

