package com.springacademy.securityjwt.service;


import com.springacademy.securityjwt.entity.Role;
import com.springacademy.securityjwt.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepo roleRepo;

    public Role createNewRole(Role role){
        return roleRepo.save(role);
    }
}
