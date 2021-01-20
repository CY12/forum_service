package com.example.forum.mapper;

import com.example.forum.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    int register(User user);

    int updateUser(User user);

    List<User> getUserByImei(String imei);

    User getUser(int id);
}
