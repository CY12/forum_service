package com.example.forum.service;

import com.example.forum.entity.User;

import java.util.List;

public interface UserService {


    int register(User user);

    int updateUser(User user);

    List<User> getUserByImei(String imei);

    User getUser(int id);


}
