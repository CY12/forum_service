package com.example.forum.service.impl;

import cn.hutool.Hutool;
import cn.hutool.json.JSONUtil;
import com.example.forum.entity.User;
import com.example.forum.mapper.UserMapper;
import com.example.forum.service.FileService;
import com.example.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    FileService fileService;

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

    @Override
    public int updateImageUser(MultipartFile file, String userJson) {
        System.out.println("=== service updateImageUser  userJson=== "+userJson);
        List<MultipartFile> files = new ArrayList<>();
        files.add(file);
        User user = JSONUtil.toBean(userJson,User.class);
        if (user==null) {
            System.out.println("user==null");
            return 0;
        }
        if (StringUtil.isEmpty(user.getAvatar())){
            int count = updateUser(user);
            if (count > 0){
                String s = fileService.uploadImageByS(files,FileService.IMG_USER,user.getId());
                if (s != null || s.length() != 0){
                    user.setAvatar(s);
                }else {
                    System.out.println("s == null");
                }
            }else {
                System.out.println("count=="+count);
                return 0;

            }
        }else {
            String s = fileService.uploadImageByS(files,FileService.IMG_USER,user.getId());
            if (s != null || s.length() != 0){
                user.setAvatar(s);
            }else {
                System.out.println("s == null");
            }
        }
        System.out.println(user.toString());
        return updateUser(user);
    }
}
