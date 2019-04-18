package com.forezp.springbootfirstapplication.controller;

import com.forezp.springbootfirstapplication.config.ConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConfigInfoController {
    @Value("${boot.name}")
    private String name;
    @Value("${boot.location}")
    private String location;

    @Autowired
    private ConfigInfo configInfo;

    @ResponseBody
    @RequestMapping("/config")
    public String config(){
        return name+"-"+location+";"+configInfo.getName()+"-"+configInfo.getLocation();
    }
}
