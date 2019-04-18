package com.forezp.springbootfirstapplication.service;

import com.forezp.springbootfirstapplication.model.Driver;

import java.util.List;

public interface DriverService {
    public List<Driver> getAllDriver();
    public int update();
}
