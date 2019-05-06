package com.tls.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.tls.springboot.mapper.UserMapper;
import com.tls.springboot.model.User;
import com.tls.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<Object,Object> restTemplate;

    @Override
    public List<User> getUserByPage(Map<String, Object> paramMap) {
        return userMapper.getUserByPage(paramMap);
    }

    @Override
    public int getUserByTotal() {
        restTemplate.setKeySerializer(new StringRedisSerializer());
        Integer totalRows = (Integer)restTemplate.opsForValue().get("totalRows");
        if(null==totalRows) {
            synchronized (this) {
                totalRows = (Integer)restTemplate.opsForValue().get("totalRows");
                if(null==totalRows){
                    totalRows=userMapper.getUserByTotal();
                    restTemplate.opsForValue().set("totalRows",totalRows);
                }
            }
        }

        return totalRows;
    }

    @Override
    public int deleteUser(Integer id) {
        int i=userMapper.deleteByPrimaryKey(id);
        if(i>0){
            int totalRows=userMapper.getUserByTotal();
            restTemplate.opsForValue().set("totalRows",totalRows);
        }
        return i;
    }

    @Override
    public int addUser(User user) {
        int i=userMapper.insert(user);
        if(i>0){
            int totalRows=userMapper.getUserByTotal();
            restTemplate.opsForValue().set("totalRows",totalRows);
        }
        return i;
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
