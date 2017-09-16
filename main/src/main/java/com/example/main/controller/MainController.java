package com.example.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hyylt")
public class MainController {

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("username","张三");
        return "index";
    }
}
