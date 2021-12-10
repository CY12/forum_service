package com.example.forum.service.impl;

import cn.hutool.json.JSONUtil;
import com.example.forum.entity.ImageSquare;
import com.example.forum.mapper.FileMapper;
import com.example.forum.mapper.ImageSquareMapper;
import com.example.forum.service.FileService;
import com.example.forum.service.ImageSquareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ImageSquareImpl implements ImageSquareService {
    @Autowired
    ImageSquareMapper imageSquareMapper;
    @Autowired
    FileService fileService;


    @Override
    public int addImageSquare(String json,List<MultipartFile> files) {
        ImageSquare imageSquare = JSONUtil.toBean(json,ImageSquare.class);
        String url = fileService.uploadImageByS(files,FileImpl.IMG_WEATHER_SQUARE,-1);
        imageSquare.setImgUrl(url);
        if (url == null){
            return 0;
        }
        System.out.println("addImageSquare"+url);
        return imageSquareMapper.addImageSquare(imageSquare);
    }

    @Override
    public List<ImageSquare> getImageSquare(int start, int size, int type) {
        return imageSquareMapper.getImageSquare(start,size,type);
    }

    @Override
    public int download(int id) {
        return imageSquareMapper.download(id);
    }

    @Override
    public int view(int id) {
        return imageSquareMapper.view(id);
    }
}
