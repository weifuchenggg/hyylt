package com.example.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestRedis {

    @RequestMapping("/set")
    public String set(HttpServletRequest request,String name){
        request.getSession().setAttribute("name",name);
        return name+"---"+request.getSession().getAttribute("name");
    }

    @RequestMapping("/get")
    public String get(HttpServletRequest request){
       return request.getSession().getAttribute("name").toString();
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser(HttpServletRequest request){
        System.out.println("aaa");
        return request.getSession().getAttribute("user")+"dddddddddd";
    }
}
