package com.forezp.springbootfirstapplication.controller;

import com.forezp.springbootfirstapplication.model.Driver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestFullController {

    @RequestMapping("/boot/driver/{id}")
    @ResponseBody
    public Object driver(@PathVariable("id")String id){
        Driver driver=new Driver();
        driver.setId(id);
        driver.setName("AAA");
        return driver;
    }

    @RequestMapping("/boot/driver/{id}/{name}")
    @ResponseBody
    public Object driver(@PathVariable("id")String id,@PathVariable("name")String name){
        Driver driver=new Driver();
        driver.setId(id);
        driver.setName(name);
        return driver;
    }
}
