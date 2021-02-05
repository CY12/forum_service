package com.example.forum.mapper;

import com.example.forum.controller.CollectionController;
import com.example.forum.entity.Collections;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CollectionMapper {
    int addCollection(Collections collections);

    int cancelCollection(int uid,int postId);

    List<Collections> getCollections(int uid);
}
