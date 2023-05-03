package com.example.hospitalsystemmanagement.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by bonda on 13.04.2023 13:28
 *
 * @author bonda
 */

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;
    @Column(name= "role_Name")
    private String roleName;

    @Override
    public String getAuthority() {
        return getRoleName();
    }
}