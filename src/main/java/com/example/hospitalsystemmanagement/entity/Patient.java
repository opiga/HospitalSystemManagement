package com.example.hospital.entity;

import java.util.Date;


/**
 * Created by bonda on 06.04.2023 19:02
 *
 * @author bonda
 * Created Patient pojo class
 */

public class Patient {
    private Integer patientId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;
    private String phoneNumber;
    private Integer doctorId;
    private Integer userNamePatient;
    private Integer nurseId;
    private Integer hospitalCardId;

    public Patient() {

    }

    public Patient(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getUserNamePatient() {
        return userNamePatient;
    }

    public void setUserNamePatient(Integer userNamePatient) {
        this.userNamePatient = userNamePatient;
    }

    public Integer getNurseId() {
        return nurseId;
    }

    public void setNurseId(Integer nurseId) {
        this.nurseId = nurseId;
    }

    public Integer getHospitalCardId() {
        return hospitalCardId;
    }

    public void setHospitalCardId(Integer hospitalCardId) {
        this.hospitalCardId = hospitalCardId;
    }
}
