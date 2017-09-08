package com.example.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping(value = "/user/{id}")
    public Object add(@PathVariable String id, HttpServletRequest request) {
        System.out.println("---------"+request.getParameter("username"));
        return restTemplate.getForEntity("http://USER/user/"+id, String.class).getBody();
    }
}
