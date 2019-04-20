package com.forezp.springboot.controller;

import com.forezp.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {
    @RequestMapping("/boot/index")
    public String index(Model model){
        model.addAttribute("msg","Springboot 集成thymeleaf");
        User user=new User("tanglsh","596911645@qq.com",28);
        model.addAttribute("user",user);


        List<User> userList=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add(new User("tanglsh"+i,"596911645@qq.com"+i,28+i));
        }

        model.addAttribute("userList",userList);
        return "html/index";
    }


}
