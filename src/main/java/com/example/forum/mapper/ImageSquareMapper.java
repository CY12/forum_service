package com.example.forum.mapper;

import com.example.forum.entity.ImageSquare;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
@Mapper
public interface ImageSquareMapper {
    int addImageSquare(ImageSquare imageSquare);

    List<ImageSquare> getImageSquare(int start, int size, int type,int pass);

    List<ImageSquare> getAllImage(int start, int size, int type,int pass);

    int downloadImg(int id);

    int view(int id);
}
