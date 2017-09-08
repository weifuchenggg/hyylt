package com.example.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserClientImpl  {

    @Autowired
    UserClient userClient;

    @RequestMapping(value = "/user/{id}")
    public String add(@PathVariable String id) {
        return userClient.add(id);
    }
}
