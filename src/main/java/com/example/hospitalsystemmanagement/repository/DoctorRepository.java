package com.example.hospitalsystemmanagement.repository;


import com.example.hospitalsystemmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by bonda on 17.04.2023 14:52
 *
 * @author bonda
 */
public interface DoctorRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users where users.role_Id=(Select roles.id from roles where roles.role_Name='doctor')", nativeQuery = true)
    List<User> findAll();

    @Query(value = "SELECT * FROM users where users.role_Id=(Select roles.id from roles where roles.role_Name='nurse')", nativeQuery = true)
    List<User> findAllNurses();

    @Query(value = "SELECT u.id, u.first_Name, u.last_Name, u.date_Of_Birth, u.email,\n" +
            "            u.phone_Number, u.address, c.name_Category,\n" +
            "            COUNT(DISTINCT a.patient_Id_Appoint) as number_Of_Patients FROM users as u \n" +
            "            \n" +
            "            LEFT JOIN appointments as a ON u.id = a.doctor_Id_Appoint\n" +
            "            JOIN categories as c ON u.category_Id = c.id\n" +
            "             WHERE u.role_Id=(Select r.id from roles as r where r.role_Name='doctor') group by u.id;", nativeQuery = true)
    List<DoctorWithUsers> findAllWithPatients();

}

