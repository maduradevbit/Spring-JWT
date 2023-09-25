package com.springacademy.securityjwt.controller;

import com.springacademy.securityjwt.entity.User;
import com.springacademy.securityjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping({"register-new-user"})
    public User registerNewUser(@RequestBody User user){

        return userService.registerNewUser(user);
    }

    @PostConstruct
    public void initRoleAndUser(){
        userService.initRoleAndUser();

    }

   @GetMapping({"/for-admin"})
    public String forAdmin(){
        return "this url only accessible for admin";
   }

    @GetMapping({"/for-user"})
    public String forUser(){
        return "this url only accessible for user";
    }
}
