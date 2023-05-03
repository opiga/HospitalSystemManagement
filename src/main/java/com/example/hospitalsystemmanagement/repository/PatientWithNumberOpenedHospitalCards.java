package com.example.hospitalsystemmanagement.repository;

import java.util.Date;

/**
 * Created by bonda on 02.05.2023 13:41
 *
 * @author bonda
 */
public interface PatientWithNumberOpenedHospitalCards {
    Long getId();

    String getFirst_Name();

    String getLast_Name();

    Date getDate_Of_Birth();

    String getEmail();

    String getPhone_Number();

    String getAddress();

    Integer getNumber_Of_Hospital_Cards();

}
