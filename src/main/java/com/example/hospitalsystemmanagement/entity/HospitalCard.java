package com.example.hospitalsystemmanagement.entity;

import javax.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Created by bonda on 13.04.2023 13:15
 *
 * @author bonda
 */
@Entity
@Table(name = "hospitalcards")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HospitalCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long hospitalCardId;
    @Column(name= "diagnosis")
    private String diagnosis;
    @Column(name= "discharged",insertable=false, updatable = false, nullable = false,columnDefinition = "VARCHAR(45) default 'false'")
    private String discharged;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_Id")
    private User doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_Id")
    private User patient;

    @OneToMany(mappedBy = "hospitalCard", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Appointment> hospitalCardAppointments;

}
