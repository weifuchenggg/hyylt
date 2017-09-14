package com.example.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hyylt")
public class MainController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
