package com.example.forum.service;

import com.example.forum.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    public static final int IMG_USER = 1;
    public static final int IMG_POST = 2;
    public static final int IMG_COMMENT = 3;
    public static final int IMG_REPLY = 4;
    public static final int IMG_WEATHER_SQUARE = 5;


    int uploadImage(List<MultipartFile> multipartFiles,int type,int typeId);

    String uploadImageByS(List<MultipartFile> multipartFiles,int type,int typeId);

    int addImage(Image image);

    List<String> getImage(int type,int typeId);
}
