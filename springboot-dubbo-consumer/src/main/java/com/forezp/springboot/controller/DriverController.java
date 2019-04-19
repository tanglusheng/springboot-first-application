package com.forezp.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.forezp.springboot.service.DriverService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController {

    @Reference(version = "1.0.0")
    private DriverService driverService;

    @RequestMapping("/boot/driver")
    public Object getDriver(String id){
        return driverService.getDriver(id);
    }
}
