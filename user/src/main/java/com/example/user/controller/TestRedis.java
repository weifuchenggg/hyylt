package com.example.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestRedis {



    @RequestMapping("/set")
    public String set(HttpServletRequest request){
        request.getSession().setAttribute("name","wfc");
        return "ok";
    }

    @RequestMapping("/get")
    public String get(HttpServletRequest request){
       return request.getSession().getAttribute("name").toString();

    }
}
