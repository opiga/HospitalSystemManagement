package com.example.hospitalsystemmanagement.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

/**
 * Created by bonda on 13.04.2023 13:30
 *
 * @author bonda
 */
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_name")
    private String username;
    @Column(name = "password")
    private String password;
    @Transient
    private String passwordConfirm;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

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
}

