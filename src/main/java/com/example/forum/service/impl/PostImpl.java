package com.example.forum.service.impl;

import cn.hutool.json.JSONUtil;
import com.example.forum.bean.Response;
import com.example.forum.entity.Post;
import com.example.forum.mapper.PostMapper;
import com.example.forum.service.FileService;
import com.example.forum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostImpl implements PostService {
    @Autowired
    PostMapper postMapper;
    @Autowired
    FileService fileService;

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
        Post post = postMapper.getPost(id);
        List<String> urls = new ArrayList<>();
        if (post.getImage()>0){
            urls = fileService.getImage(FileService.IMG_POST,id);
        }
        post.setUrlList(urls);
        return post;
    }

    @Override
    public List<Post> getPostList(int start, int size) {
        List<Post> postList = postMapper.getPostList(start,size);
        for (int i=0;i<postList.size();i++){
            List<String> urls = new ArrayList<>();
            if (postList.get(i).getImage() > 0){
                 urls = fileService.getImage(FileService.IMG_POST,postList.get(i).getId());

            }
            postList.get(i).setUrlList(urls);
        }
        return postList;
    }

    @Override
    public List<Post> getPostByUser(int uid) {
        List<Post> postList = postMapper.getPostByUser(uid);;
        for (int i=0;i<postList.size();i++){
            List<String> urls = new ArrayList<>();
            if (postList.get(i).getImage() > 0){
                urls = fileService.getImage(FileService.IMG_POST,postList.get(i).getId());
            }
            postList.get(i).setUrlList(urls);
        }
        return postList;
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

    @Override
    public Response addImagePost(List<MultipartFile> multipartFiles, String postJson) {
        Post post = JSONUtil.toBean(postJson,Post.class);
        int count = addPost(post);;
        if (count > 0){
            int error = fileService.uploadImage(multipartFiles,FileService.IMG_POST,post.getId());
            if (error > 0){
                return Response.error("图片上传失败");
            }
        }else {
            return Response.error("发布失败");
        }

        return Response.success();
    }

}
