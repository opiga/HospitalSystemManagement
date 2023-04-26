//package com.example.hospital.entity;
//
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//
///**
// * Created by bonda on 06.04.2023 18:29
// *
// * @author bonda
// */
//@Component
//@Scope(value = "prototype")
//public class Doctor {
//private Integer doctorId;
//private String firstName;
//private String lastName;
//private String category;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//
//        Doctor doctor = (Doctor) o;
//
//        if (doctorId != doctor.doctorId) {
//            return false;
//        }
//        if (firstName != null ? !firstName.equals(doctor.firstName) : doctor.firstName != null) {
//            return false;
//        }
//        if (lastName != null ? !lastName.equals(doctor.lastName) : doctor.lastName != null) {
//            return false;
//        }
//        return category != null ? category.equals(doctor.category) : doctor.category == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = doctorId;
//        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
//        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
//        result = 31 * result + (category != null ? category.hashCode() : 0);
//        return result;
//    }
//
//    public Integer getId() {
//        return doctorId;
//    }
//
//    public void setId(Integer id) {
//        this.doctorId = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//}
