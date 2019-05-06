package com.tls.springboot.service;

import com.tls.springboot.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> getUserByPage(Map<String,Object> paramMap);
    int getUserByTotal();
    int deleteUser(Integer id);
    int addUser(User user);
    int updateUser(User user);
    User getUserById(Integer id);
}
