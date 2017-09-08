package com.example.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Value("${server.port}")
    String port;
    @RequestMapping("/login")
    public String login(String username){
        return "success:  "+username+"   "+port;
    }

}
