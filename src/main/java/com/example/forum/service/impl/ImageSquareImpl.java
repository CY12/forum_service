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
        int success = 0;
        for (MultipartFile file : files){
            String url = fileService.uploadImageByS(file,FileImpl.IMG_WEATHER_SQUARE,-1);
            if (url != null){
                ImageSquare imageSquare = JSONUtil.toBean(json,ImageSquare.class);
                imageSquare.setImgUrl(url);
                imageSquareMapper.addImageSquare(imageSquare);
                success++;
            }
        }
        return success;
    }

    @Override
    public List<ImageSquare> getImageSquare(int start, int size, int type) {
            if (type == 10){
                return imageSquareMapper.getAllImage(start,size,type,0);
            }
        return imageSquareMapper.getImageSquare(start,size,type,0);
    }

    @Override
    public int downloadImg(int id) {
        return imageSquareMapper.downloadImg(id);
    }

    @Override
    public int view(int id) {
        return imageSquareMapper.view(id);
    }
}
