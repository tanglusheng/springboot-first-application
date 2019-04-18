package com.forezp.springbootfirstapplication.service.impl;

import com.forezp.springbootfirstapplication.mapper.DriverMapper;
import com.forezp.springbootfirstapplication.model.Driver;
import com.forezp.springbootfirstapplication.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService{
    @Autowired
    private DriverMapper driverMapper;

    /*注入springboot自动配置好的RedisTemplate*/
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Override
    public /*synchronized*/ List<Driver> getAllDriver() {
        RedisSerializer redisSerializer=new StringRedisSerializer();
        //设置key序列化器
        redisTemplate.setKeySerializer(redisSerializer);
        //设置value序列化器
        RedisSerializer valueSerializer=new Jackson2JsonRedisSerializer(List.class);
        redisTemplate.setValueSerializer(valueSerializer);
        //高并发情况下，此处有问题L:缓存穿透
        //查询缓存
        List<Driver> drivers=(List<Driver>)redisTemplate.opsForValue().get("allDrivers");
        //双重检测锁
        if(null==drivers){
            synchronized (this){
                drivers=(List<Driver>)redisTemplate.opsForValue().get("allDrivers");
                if(null==drivers){
                    drivers=driverMapper.getAllDriver();
                    System.out.println("查询数据库...");
                    //这样存入redis中的key也是序列化的key，不好读，可以给它设置序列化类
                    redisTemplate.opsForValue().set("allDrivers",drivers);
                }
            }
        }else{
            System.out.println("查询缓存...");
        }
        return drivers;
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
