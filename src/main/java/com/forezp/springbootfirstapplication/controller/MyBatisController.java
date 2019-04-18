package com.forezp.springbootfirstapplication.controller;

import com.forezp.springbootfirstapplication.model.Driver;
import com.forezp.springbootfirstapplication.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class MyBatisController {
    @Autowired
    private DriverService driverService;

    @RequestMapping("/mybatis/getAllDriver")
    public List<Driver> getAllDriver(){
        //线程，该线程调用底层查询所有driver的方法

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                driverService.getAllDriver();
            }
        };
        //多线程测试一下缓存穿透问题
        ExecutorService executorService = Executors.newFixedThreadPool(25);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(runnable);
        }

        return driverService.getAllDriver();
    }

    @RequestMapping("/mybatis/update")
    public String update(){
        return driverService.update()==1?"更新成功":"更新失败";
    }
}
