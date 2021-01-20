package com.example.forum.controller;

import com.example.forum.bean.Response;
import com.example.forum.entity.Comment;
import com.example.forum.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;


    @PostMapping(value = "/addComment")
    public Response addComment(@RequestBody Comment comment){
        if (comment == null) {
            return Response.errorParams();
        }
        int count = commentService.addComment(comment);
        if (count <= 0){
            return Response.error();
        }
        return getResponse(comment);
    }
    @PostMapping(value = "/getComment")
    public Response getComment(int id){
        return getResponse(commentService.getComment(id));
    }

    @PostMapping(value = "/deleteComment")
    public Response deleteComment(int id){
        return getResponse(commentService.deleteComment(id));
    }

    @PostMapping(value = "/getCommentList")
    public Response getCommentList(int postId,int start,int size){
        return getResponse(commentService.getCommentList(postId,start,size));
    }

    @PostMapping(value = "/getCommentByUser")
    public Response getCommentByUser(int uid){
        return getResponse(commentService.getCommentByUser(uid));
    }

    @PostMapping(value = "/reply")
    public Response reply(int id,int count){
        if (count == 0){
            return Response.errorParams();
        }
        if (count == 1){
            return Response.getResponse(commentService.reply(id));
        }else if (count == -1){
            return Response.getResponse(commentService.cancelReply(id));
        }
        return Response.error();
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
