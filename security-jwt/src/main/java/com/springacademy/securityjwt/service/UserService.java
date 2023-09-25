package com.springacademy.securityjwt.service;

import com.springacademy.securityjwt.entity.Role;
import com.springacademy.securityjwt.entity.User;
import com.springacademy.securityjwt.repo.RoleRepo;
import com.springacademy.securityjwt.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user) {
        return userRepo.save(user);
    }

    public void initRoleAndUser(){
        Role adminRole = new Role();
        if (!roleRepo.existsById("Admin")) {
            adminRole.setRoleName("Admin");
            adminRole.setRoleDescription("Admin Role description");
            roleRepo.save(adminRole);
        }
        Role userRole = new Role();
        if (!roleRepo.existsById("User")) {
            userRole.setRoleName("User");
            userRole.setRoleDescription("User Role description");
            roleRepo.save(userRole);
        }


        if(!userRepo.existsById("admin123")) {
        User user=new User();
        user.setUserName("admin123");
        user.setUserPassword(getEncodedPassword("admin@123"));
        user.setUserFirstName("test1");
        user.setUserLastName("test2");

            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(adminRole);
            user.setRole(adminRoles);
            userRepo.save(user);
        }



        if(!userRepo.existsById("user123")) {
            User user=new User();
            user.setUserName("user123");
            user.setUserPassword(getEncodedPassword("user@123"));
            user.setUserFirstName("test3");
            user.setUserLastName("test4");

            Set<Role> userRoles = new HashSet<>();
            userRoles.add(userRole);
            user.setRole(userRoles);
            userRepo.save(user);
        }

    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);

    }
}
