package com.example.hospitalsystemmanagement.entity;

import javax.persistence.*;
import lombok.*;


/**
 * Created by bonda on 13.04.2023 13:24
 *
 * @author bonda
 */
@Entity
@Table(name = "appointments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "procedures")
    private String procedures;
    @Column(name = "medications")
    private String medications;
    @Column(name = "operations")
    private String operations;
    @Column(name = "date")
    private String date;
    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(255) default 'appointed'")
    private String status;

    @ManyToOne
    @JoinColumn(name = "patient_Id_Appoint")
    User patient;
//
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nurse_Id")
    private User nurse;
//
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_Id_Appoint")
    private User doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_Card_Id")
    private HospitalCard hospitalCard;

}
