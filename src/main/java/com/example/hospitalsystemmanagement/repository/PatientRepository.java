package com.example.hospitalsystemmanagement.repository;

import com.example.hospitalsystemmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by bonda on 16.04.2023 20:05
 *
 * @author bonda
 */
public interface PatientRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users where users.role_Id=(Select roles.id from roles where roles.role_Name='patient')", nativeQuery = true)
    public List<User> findAll();

    @Query(value = "SELECT u.id, u.first_Name, u.last_Name, u.date_Of_Birth, u.email,\n" +
            "            u.phone_Number, u.address, h.id as hospital_Card_Id, h.diagnosis as diagnosis , h.discharged as discharged, h.doctor_Id as doctor_Id, d.first_Name as doctor_First_Name, d.last_Name as doctor_Last_Name, c.name_Category as doctor_Name_Category FROM users as u \n" +
            "            left JOIN hospitalcards as h ON u.id = h.patient_Id\n" +
            "            left JOIN users as d ON h.doctor_Id = d.id\n" +
            "              left JOIN categories as c ON d.category_Id = c.id\n" +
            "            where u.role_Id=(Select roles.id from roles where roles.role_Name='patient');", nativeQuery = true)
    public List<PatientWithHospitalCardAndDoctor> findAllWithHospitalCardsAndDoctors();

    @Query(value = "SELECT u.id, u.first_Name, u.last_Name, u.date_Of_Birth, u.email,\n" +
            "            u.phone_Number, u.address, COUNT(h.id) as number_Of_Hospital_Cards\n" +
            "FROM users AS u \n" +
            "LEFT JOIN hospitalcards AS h ON u.id = h.patient_Id AND h.discharged = 'false'\n" +
            "WHERE u.role_Id = (SELECT roles.id FROM roles WHERE roles.role_Name = 'patient')\n" +
            "      AND (h.id IS NULL OR h.discharged = 'false')\n" +
            "GROUP BY u.id;", nativeQuery = true)
    public List<PatientWithNumberOpenedHospitalCards> findAllWithNumberOpenedHospitalCards();
}

