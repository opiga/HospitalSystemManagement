package com.example.hospitalsystemmanagement.service;

import com.example.hospitalsystemmanagement.entity.Role;

import java.util.List;

/**
 * Created by bonda on 01.05.2023 16:44
 *
 * @author bonda
 */
public interface RoleService {

    public Role findByName(String roleName);
    public List<Role> findAll();

    public Role findById(Long theId);

    public void save(Role theCategory);

    public void deleteById(Long theId);
}
