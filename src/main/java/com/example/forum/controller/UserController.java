package com.example.forum.controller;

import com.example.forum.bean.Response;
import com.example.forum.entity.User;
import com.example.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public Response register(@RequestBody User user){
        if (user == null || user.getImei().length() <= 0){
            return Response.errorParams();
        }
        List<User> users = userService.getUserByImei(user.getImei());
        if (users!= null && users.size() >  0){
            return Response.error(Response.CODE_EXIST,"用户已存在");
        }
        if (userService.register(user) > 0){
            return getResponse(user);
        }else {
            return Response.error();
        }

    }

    @PostMapping(value = "/updateUser")
    public Response updateUser(@RequestBody User user){

        if (user == null){
            return Response.errorParams();
        }
        if (userService.updateUser(user) > 0){
            return getResponse(user);
        }
        return getResponse(userService.updateUser(user));
    }

    @PostMapping(value = "/getUserByImei")
    public Response getUserByImei(String imei){
        if (imei == null) {
            return Response.errorParams();
        }
        return getResponse(userService.getUserByImei(imei));
    }

    @PostMapping(value = "/getUser")
    public Response getUser(int id){
        return getResponse(userService.getUser(id));
    }


    @PostMapping(value = "/updateImageUser")
    public Response updateImageUser(MultipartFile file,String userJson){

        if (file.isEmpty() || userJson.length() == 0){
            return Response.errorParams();
        }
        return getResponse(userService.updateImageUser(file,userJson));
    }


    private Response getResponse(int count){
        if (count > 0){
            return Response.success();
        }
        return Response.error();

    }

    private <T> Response getResponse(T data){
        if (data != null){
            return Response.success(data);
        }
        return Response.error();
    }
}
