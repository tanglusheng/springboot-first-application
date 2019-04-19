package com.forezp.springboot.mapper;


import com.forezp.springboot.model.Driver;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper//可以使用扫描的方式
public interface DriverMapper {
    int deleteByPrimaryKey(String id);

    int insert(Driver record);

    int insertSelective(Driver record);

    Driver selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Driver record);

    int updateByPrimaryKey(Driver record);

    List<Driver> getAllDriver();
}