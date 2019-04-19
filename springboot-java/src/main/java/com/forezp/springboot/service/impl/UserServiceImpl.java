package com.forezp.springboot.service.impl;

import com.forezp.springboot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public String sayHi(String name) {
        return "hi "+name;
    }
}
