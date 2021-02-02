package com.example.forum.service;

import com.example.forum.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {


    int register(User user);

    int updateUser(User user);

    List<User> getUserByImei(String imei);

    User getUser(int id);

    int updateImageUser(MultipartFile file,String userJson);


}
