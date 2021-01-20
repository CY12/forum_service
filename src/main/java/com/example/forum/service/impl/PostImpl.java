package com.example.forum.service.impl;

import com.example.forum.entity.Post;
import com.example.forum.mapper.PostMapper;
import com.example.forum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostImpl implements PostService {
    @Autowired
    PostMapper postMapper;

    @Override
    public int addPost(Post post) {
        return postMapper.addPost(post);
    }

    @Override
    public int deletePost(int id) {
        return postMapper.deletePost(id);
    }

    @Override
    public int updatePost(Post post) {
        return postMapper.updatePost(post);
    }

    @Override
    public Post getPost(int id) {
        return postMapper.getPost(id);
    }

    @Override
    public List<Post> getPostList(int start, int size) {
        return postMapper.getPostList(start,size);
    }

    @Override
    public List<Post> getPostByUser(int uid) {
        return postMapper.getPostByUser(uid);
    }

    @Override
    public int star(int id) {
        return postMapper.star(id);
    }

    @Override
    public int cancelStar(int id) {
        return postMapper.cancelStar(id);
    }

    @Override
    public int view(int id) {
        return postMapper.view(id);
    }

    @Override
    public int comment(int id) {
        return postMapper.comment(id);
    }

    @Override
    public int cancelComment(int id) {
        return postMapper.cancelComment(id);
    }



}
