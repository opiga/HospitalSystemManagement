package com.example.hospitalsystemmanagement.service.serviceImpl;

import com.example.hospitalsystemmanagement.entity.Role;
import com.example.hospitalsystemmanagement.repository.RoleRepository;
import com.example.hospitalsystemmanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by bonda on 01.05.2023 16:45
 *
 * @author bonda
 */
@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository theRoleRepository) {
        roleRepository = theRoleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long theId) {
        Optional<Role> result = roleRepository.findById(theId);
        Role theRole = null;
        if (result.isPresent()) {
            theRole = result.get();
        }
        else {
            throw new RuntimeException("Did not find role id - " + theId);
        }
        return theRole;
    }

    @Override
    public void save(Role theRole) {
        roleRepository.save(theRole);
    }

    @Override
    public void deleteById(Long theId) {
        roleRepository.deleteById(theId);
    }

    @Override
    public Role findByName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}
