package com.example.hospitalsystemmanagement.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
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
    @Column(name = "id")
    private Long hospitalCardId;
    @Column(name = "preliminary_diagnosis")
    private String preliminaryDiagnosis;
    @Column(name = "clinical_diagnosis")
    private String clinicalDiagnosis;
    @Column(name = "final_diagnosis")
    private String finalDiagnosis;

    @Column(name = "discharged", nullable = false, columnDefinition = "VARCHAR(45) default 'false'")
    private String discharged;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_Id")
    private User doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_Id")
    private User patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nurse_Id")
    private User nurse;

    @OneToMany(mappedBy = "hospitalCard", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Appointment> hospitalCardAppointments;

}
