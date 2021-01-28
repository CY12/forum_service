package com.example.forum.controller;

import com.example.forum.bean.Response;
import com.example.forum.entity.Post;
import com.example.forum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    /**
     * 发表帖子
     * @param post
     * @return
     */
    @PostMapping(value = "/addPost")
    public Response addPost(@RequestBody Post post){
        if (post == null) {
            return Response.errorParams();
        }
        int count = postService.addPost(post);
        if ( count > 0){
            return Response.success();
        }
        return Response.error();
    }

    /**
     * 更改某一个
     * @param post
     * @return
     */
    @PostMapping(value = "/updatePost")
    public Response updatePost(@RequestBody Post post){
        if (post == null || post.getId() == 0) {
            return Response.errorParams();
        }
        int count = postService.updatePost(post);
        if (count > 0){
            return Response.success();
        }
        return Response.error();
    }

    /**
     * 删除某一个
     * @param id
     * @return
     */
    @PostMapping(value = "/deletePost")
    public Response deletePost(int id){
        if (id == 0){
            return Response.errorParams();
        }
        int count = postService.deletePost(id);
        return getResponse(count);
    }

    /**
     * 获取列表
     * @param id
     * @return
     */
    @PostMapping(value = "/getPost")
    public Response<Post> getPost(int id){
        if (id == 0){
            return Response.errorParams();
        }

        return getResponse(postService.getPost(id));
    }

    /**
     * 获取所有帖子列表
     * @return
     */
    @PostMapping(value = "/getPostList")
    public Response getPostList(int start,int size){
        return getResponse(postService.getPostList(start, size));
    }

    @PostMapping(value = "/getPostByUser")
    public Response<List<Post>> getPostByUser(int uid){
        if (uid == 0){
            return Response.errorParams();
        }
        return getResponse(postService.getPostByUser(uid));

    }

    @PostMapping(value = "/star")
    public Response star(int id,int count){
        if (count == 0 ) {
            return Response.errorParams();
        }
        if (count == 1){
            return getResponse(postService.star(id));
        }else if (count == -1){
            return getResponse(postService.cancelStar(id));
        }
        return Response.error();
    }

    @PostMapping(value = "/comment")
    public Response comment(int id,int count){
        if (count == 0 ) {
            return Response.errorParams();
        }
        if (count == 1){
            return getResponse(postService.comment(id));
        }else if (count == -1){
            return getResponse(postService.cancelComment(id));
        }
        return Response.error();
    }

    @PostMapping(value = "/view")
    public Response view(int id){
        return getResponse(postService.view(id));
    }



    private Response getResponse(int count){
        if (count > 0){
            return Response.success();
        }
        return Response.error();
    }

    private <T> Response getResponse(T data){
        if (data != null){
            return Response.success(data);
        }
        return Response.error();
    }

}
