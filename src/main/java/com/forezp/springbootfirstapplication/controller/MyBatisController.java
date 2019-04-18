package com.forezp.springbootfirstapplication.controller;

import com.forezp.springbootfirstapplication.model.Driver;
import com.forezp.springbootfirstapplication.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyBatisController {
    @Autowired
    private DriverService driverService;

    @RequestMapping("/mybatis/getAllDriver")
    public List<Driver> getAllDriver(){
        return driverService.getAllDriver();
    }

    @RequestMapping("/mybatis/update")
    public String update(){
        return driverService.update()==1?"更新成功":"更新失败";
    }
}
