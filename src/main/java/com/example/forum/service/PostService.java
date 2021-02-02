package com.example.forum.service;

import com.example.forum.bean.Response;
import com.example.forum.entity.Post;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {
    int addPost(Post post);

    int deletePost(int id);

    int updatePost(Post post);

    Post getPost(int id);

    List<Post> getPostList(int start,int size);

    List<Post> getPostByUser(int uid);

    int star (int id);

    int cancelStar(int id);

    int view(int id);

    int comment(int id);

    int cancelComment(int id);

    Response addImagePost(List<MultipartFile> multipartFiles, String postJson);



}
