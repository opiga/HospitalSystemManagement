package com.example.hospitalsystemmanagement.repository;

import com.example.hospitalsystemmanagement.entity.HospitalCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HospitalCardRepository extends JpaRepository<HospitalCard, Long> {
    @Query(value = "SELECT * FROM hospitalcards as h where h.patient_Id=?", nativeQuery = true)
    List<HospitalCard> findAllByPatientId(Long id);

    @Query(value = "SELECT * FROM hospitalcards as h where h.doctor_Id=?", nativeQuery = true)
    List<HospitalCard> findAllByDoctorId(Long id);

    @Query(value = "SELECT * FROM hospitalcards as h where h.nurse_Id=?", nativeQuery = true)
    List<HospitalCard> findAllByNurseId(Long id);

}
