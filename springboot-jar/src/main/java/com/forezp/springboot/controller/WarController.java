package com.forezp.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WarController {
    @RequestMapping("/boot/json")
    @ResponseBody
    public Object json(){
        Map<String,Object> map=new HashMap<>();
        map.put("name","北京动力节点");
        map.put("address","北京大兴");
        return map;
    }

    @RequestMapping("/boot/jsp")
    public String jsp(Model model){
        model.addAttribute("name","北京动力节点");
        return "index";
    }
}
