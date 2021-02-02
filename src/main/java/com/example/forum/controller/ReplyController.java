package com.example.forum.controller;

import com.example.forum.bean.Response;
import com.example.forum.entity.Reply;
import com.example.forum.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ReplyController {
    @Autowired
    ReplyService replyService;

//    int addReply(Reply reply);
//
//    List<Reply> getReplyList(int commentId);

    /**
     * 增加回复
     * @param reply
     * @return
     */
    @PostMapping(value = "/addReply")
    public Response addReply(@RequestBody Reply reply){
        if (reply == null){
            return Response.errorParams();
        }

        return Response.getResponse(replyService.addReply(reply));
    }

    /**
     * 获取所有回复
     * @param commentId
     * @return
     */
    @PostMapping(value = "/getReplyList")
    public Response getReplyList(int commentId){

        return Response.getResponse(replyService.getReplyList(commentId));
    }

    @PostMapping(value = "/getReplyDetail")
    public Response getReplyDetail(int commentId){
        return Response.getResponse(replyService.getReplyDetail(commentId));
    }

    @PostMapping(value = "/addImageReply")
    public Response addImageReply(List<MultipartFile> files,int type,String reply){

        return replyService.addImageReply(files,type,reply);
    }


}
