package com.forezp.springbootfirstapplication.service.impl;

import com.forezp.springbootfirstapplication.mapper.DriverMapper;
import com.forezp.springbootfirstapplication.model.Driver;
import com.forezp.springbootfirstapplication.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService{
    @Autowired
    private DriverMapper driverMapper;
    @Override
    public List<Driver> getAllDriver() {
        return driverMapper.getAllDriver();
    }

    @Transactional
    @Override
    public int update() {
        Driver driver=new Driver();
        driver.setId("1");
        driver.setName("tls");
        int i = driverMapper.updateByPrimaryKey(driver);
        System.out.println("更新结果:"+i);
        int a=10/0;

        return i;
    }
}
