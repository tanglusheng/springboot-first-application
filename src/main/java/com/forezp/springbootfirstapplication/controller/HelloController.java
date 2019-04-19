package com.forezp.springbootfirstapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/boot/hello")
    @ResponseBody
    public String hello(){
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/boot/index")
    public String index(Model model){
        model.addAttribute("msg","Spring boot 集成 jsp");
        return "index";
    }
}
