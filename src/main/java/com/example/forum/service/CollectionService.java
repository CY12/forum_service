package com.example.forum.service;


import com.example.forum.entity.Collections;

import java.util.List;

public interface CollectionService {

    int addCollection(int uid,int postId);

    int cancelCollection(int uid,int postId);

    List<Collections> getCollections(int uid);
}
