package com.example.forum.service.impl;

import com.example.forum.entity.User;
import com.example.forum.mapper.UserMapper;
import com.example.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int register(User user) {
        return userMapper.register(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> getUserByImei(String imei) {
        return userMapper.getUserByImei(imei);
    }

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }
}
