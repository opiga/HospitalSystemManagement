package com.example.hospitalsystemmanagement.repository;

import com.example.hospitalsystemmanagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "SELECT * FROM roles as r where r.role_Name=?", nativeQuery = true)
    public Role findByName(String roleName);
}
