package com.forezp.springbootfirstapplication.mapper;

import com.forezp.springbootfirstapplication.model.Driver;

import java.util.List;

//@Mapper可以使用扫描的方式
public interface DriverMapper {
    int deleteByPrimaryKey(String id);

    int insert(Driver record);

    int insertSelective(Driver record);

    Driver selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Driver record);

    int updateByPrimaryKey(Driver record);

    List<Driver> getAllDriver();
}