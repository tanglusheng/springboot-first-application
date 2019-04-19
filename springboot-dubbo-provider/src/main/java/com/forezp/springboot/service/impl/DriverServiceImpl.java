package com.forezp.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.forezp.springboot.mapper.DriverMapper;
import com.forezp.springboot.model.Driver;
import com.forezp.springboot.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
@Service(version = "1.0.0",timeout = 10000)
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverMapper driverMapper;

    @Override
    public String sayHi(String name) {
        return "hello:"+name;
    }

    @Override
    public Driver getDriver(String id) {
        return driverMapper.selectByPrimaryKey(id);
    }

}
