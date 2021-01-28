package com.example.forum.controller;

import com.example.forum.bean.Response;
import com.example.forum.entity.Image;
import com.example.forum.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class FileController {
    @Autowired
    FileService fileService;


    @PostMapping(value = "/uploadImage")
    public Response uploadImage(List<MultipartFile> files, int type, int typeId){
       if (files.size() == 0 || type == 0 || typeId == 0){
           return Response.errorParams();
       }

       return Response.getUploadResponse(fileService.uploadImage(files,type,typeId));
    }

    @PostMapping(value = "/getImage")
    public Response getImage(int type,int typeId){
        return Response.getResponse(fileService.getImage(type,typeId));
    }

    @PostMapping(value = "/addImage")
    public Response addImage(@RequestBody Image image){
        return Response.getResponse(fileService.addImage(image));
    }
}
