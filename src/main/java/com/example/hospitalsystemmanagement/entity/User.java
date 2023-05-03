package com.example.hospitalsystemmanagement.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by bonda on 13.04.2023 13:30
 *
 * @author bonda
 */
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_Name")
    private String firstName;
    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "date_Of_Birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_Number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;

    @Column(name = "user_Name")
    private String username;
    @Column(name = "password")
    private String password;
    @Transient
    private String passwordConfirm;
    @ManyToOne
    @JoinColumn(name = "category_Id", referencedColumnName = "id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "role_Id", referencedColumnName = "id")
    private Role role;



    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Appointment> patientAppointments;


    @OneToMany(mappedBy = "nurse", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Appointment> nurseAppointments;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Appointment> doctorAppointments;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<HospitalCard> patientHospitalCards;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<HospitalCard> doctorHospitalCards;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> auths = new ArrayList<>();
        String role = "ROLE_USER";
        for (RoleType roleType : RoleType.values()) {
            if (roleType.getRoleId() == getRole().getId()) {
                role = "ROLE_" + roleType.name();
            }
        }
        auths.add(new SimpleGrantedAuthority(role));
        return auths;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getFirstNameAndLastName( )
    {
        return firstName+"  "+lastName;
    };
}
