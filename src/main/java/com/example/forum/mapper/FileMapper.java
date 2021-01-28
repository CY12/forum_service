package com.example.forum.mapper;

import com.example.forum.entity.Image;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
@Mapper
public interface FileMapper {

    int addImage(Image image);

    List<String> getImage(int type, int typeId);
}
