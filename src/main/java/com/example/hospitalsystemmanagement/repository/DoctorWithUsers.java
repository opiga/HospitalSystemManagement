package com.example.hospitalsystemmanagement.repository;

import java.util.Date;

/**
 * Created by bonda on 01.05.2023 15:21
 *
 * @author bonda
 */
public interface DoctorWithUsers {
    Long getId();

    String getFirst_Name();

    String getLast_Name();

    Date getDate_Of_Birth();

    String getEmail();

    String getPhone_Number();

    String getAddress();

    String getName_Category();

    Integer getNumber_Of_Patients();
}