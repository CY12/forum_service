package com.example.forum.service.impl;

import com.example.forum.controller.CollectionController;
import com.example.forum.entity.Collections;
import com.example.forum.entity.Post;
import com.example.forum.mapper.CollectionMapper;
import com.example.forum.service.CollectionService;
import com.example.forum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionImpl implements CollectionService {
    @Autowired
    CollectionMapper collectionMapper;

    @Autowired
    PostService postService;
    @Override
    public int addCollection(int uid, int postId) {
        Collections collections = new Collections();
        collections.setUid(uid);
        collections.setPostId(postId);
        System.out.println(collections.toString());
        return collectionMapper.addCollection(collections);
    }

    @Override
    public int cancelCollection(int uid,int postId) {
        return collectionMapper.cancelCollection(uid,postId);
    }

    @Override
    public List<Collections> getCollections(int uid) {

        List<Collections> collections= collectionMapper.getCollections(uid);
        for (int i=0;i<collections.size();i++){
            Post post = postService.getPost(collections.get(i).getPostId());
            collections.get(i).setPost(post);
        }

        return collections;
    }
}
