package com.example.forum.service;

import com.example.forum.bean.Response;
import com.example.forum.entity.Reply;
import com.example.forum.entity.ReplyDetail;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ReplyService {
    int addReply(Reply reply);

    Response addImageReply(List<MultipartFile> multipartFiles,int type ,String reply);

    List<Reply> getReplyList(int commentId);

    ReplyDetail getReplyDetail(int commentId);



}
