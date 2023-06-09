package com.example.hospitalsystemmanagement.service;

import com.example.hospitalsystemmanagement.entity.HospitalCard;

import java.util.List;

/**
 * Created by bonda on 16.04.2023 20:03
 *
 * @author bonda
 */
public interface HospitalCardService {
    public List<HospitalCard> findAllByPatientId(Long id);
    public List<HospitalCard> findAllByDoctorId(Long id);
    public List<HospitalCard> findAllByNurseId(Long id);

    public HospitalCard findById(Long theId);

    public void save(HospitalCard theHospitalCard);

    public void deleteById(Long theId);

}
