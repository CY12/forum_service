package com.example.forum.service;

import com.example.forum.entity.ImageSquare;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageSquareService {
    int addImageSquare(String imageSquare,List<MultipartFile> files);

    List<ImageSquare> getImageSquare(int start,int size,int type);

    int downloadImg(int id);

    int view(int id);
}
