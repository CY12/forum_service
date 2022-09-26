package com.example.forum.controller;

import com.example.forum.bean.Response;
import com.example.forum.entity.Key;
import com.example.forum.service.heroservice.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")
public class KeyControl {
    @Autowired
    KeyService keyService;


    @PostMapping(value = "/addKey")
    public Response addKey(@RequestBody Key key){
        if (key == null) {
            return Response.errorParams();
        }
        int count = keyService.addKey(key);
        if ( count > 0){
            return Response.success();
        }
        return Response.error();
    }

    @PostMapping(value = "/addKeyList")
    public Response addKeyList(@RequestBody List<Key> key){
        if (key == null) {
            return Response.errorParams();
        }
        int count = 0;
        for (Key key1: key){
            count = count + keyService.addKey(key1);
        }
        if ( count == key.size()){
            return Response.success();
        }
        return Response.error();
    }



    @PostMapping(value = "/getAllKey")
    public Response getAllKey(){

        return Response.getResponse(keyService.getAllKey());
    }



}
