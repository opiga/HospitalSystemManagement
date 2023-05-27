package com.example.hospitalsystemmanagement.repository;

import java.util.Date;

/**
 * Created by bonda on 02.05.2023 13:08
 *
 * @author bonda
 */
public interface PatientWithHospitalCardAndDoctor {
    Long getId();

    String getFirst_Name();

    String getLast_Name();

    Date getDate_Of_Birth();

    String getEmail();

    String getPhone_Number();

    String getAddress();

    Integer getHospital_Card_Id();

    String getDiagnosis();

    String getDischarged();

    Integer getDoctor_Id();

    String getDoctor_First_Name();

    String getDoctor_Last_Name();

    String getDoctor_Name_Category();
}
