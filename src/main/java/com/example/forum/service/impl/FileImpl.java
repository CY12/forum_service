package com.example.forum.service.impl;

import com.example.forum.entity.Image;
import com.example.forum.mapper.FileMapper;
import com.example.forum.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileImpl implements FileService {
    @Autowired
    FileMapper fileMapper;

    @Override
    public int uploadImage(List<MultipartFile> multipartFiles, int type, int typeId) {
        System.out.println("uploadImage multipartFiles length "+multipartFiles.size());
        int error;
        int success = 0;
        for (MultipartFile multipartFile : multipartFiles){
            if (!multipartFile.isEmpty()){
                String endless = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
                long timeMillis = System.currentTimeMillis();
                String filePath = "/home/public/";
                int random=(int)(Math.random()*900)+100;
                String url = timeMillis+random+endless;
                File dest = new File(filePath+url);
                try {
                    multipartFile.transferTo(dest);
                    Image image = new Image();
                    image.setUrl(url);
                    image.setType(type);
                    image.setTypeId(typeId);
                    int addSuccess = addImage(image);
                    if (addSuccess > 0){
                        success++;
                    }
                } catch (IOException e) {
                    System.out.println("FileImpl 上传失败========="+e.toString());
                }
            }else {
                System.out.println("FileImpl files empty ====== 图片资源为空 ");
            }
        }
        error = multipartFiles.size() - success;
        return error;
    }

    @Override
    public String uploadImageByS(List<MultipartFile> multipartFiles, int type, int typeId) {
        System.out.println("uploadImage multipartFiles length "+multipartFiles.size());

        String url = null;
        int error;
        int success = 0;
        for (MultipartFile multipartFile : multipartFiles){
            if (!multipartFile.isEmpty()){
                String endless = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
                long timeMillis = System.currentTimeMillis();
                String filePath = "/home/public/";
                int random=(int)(Math.random()*900)+100;
                url = timeMillis+random+endless;
                File dest = new File(filePath+url);
                try {
                    multipartFile.transferTo(dest);
                    Image image = new Image();
                    image.setUrl(url);
                    image.setType(type);
                    image.setTypeId(typeId);
                    int addSuccess = addImage(image);
                    if (addSuccess > 0){
                        success++;
                    }
                } catch (IOException e) {
                    System.out.println("FileImpl 上传失败========="+e.toString());
                }
            }else {
                System.out.println("FileImpl files empty ====== 图片资源为空 ");
            }
        }
        error = multipartFiles.size() - success;

        if (error > 0){
            return null;
        }
        return "http://152.136.137.189:8082/data/"+url;

    }


    @Override
    public int addImage(Image image) {
        System.out.println("addImage");
        return fileMapper.addImage(image);
    }

    @Override
    public List<String> getImage(int type, int typeId) {
        String baseUrl = "http://152.136.137.189:8082/data/";
        List<String> images = fileMapper.getImage(type,typeId);
        List<String> url = new ArrayList<>();
        for (String image : images){
            url.add(baseUrl+image);
        }
        return url;
    }
}
