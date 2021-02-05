package com.example.forum.controller;


import com.example.forum.bean.Response;
import com.example.forum.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Autowired
    CollectionService collectionService;

    @RequestMapping(value = "/addCollection",method = RequestMethod.POST)
    public Response addCollection(int uid,int postId){

        return Response.getResponse(collectionService.addCollection(uid, postId));
    }

    @RequestMapping(value = "/getCollections",method = RequestMethod.POST)
    public Response getCollections(int uid){

        return Response.getResponse(collectionService.getCollections(uid));
    }

    @RequestMapping(value = "/cancelCollection")
    public Response cancelCollection(int uid,int postId){
        return Response.getResponse(collectionService.cancelCollection(uid,postId));
    }
}
