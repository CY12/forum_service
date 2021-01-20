package com.example.forum.service;

import com.example.forum.entity.Reply;
import com.example.forum.entity.ReplyDetail;

import java.util.List;

public interface ReplyService {
    int addReply(Reply reply);

    List<Reply> getReplyList(int commentId);

    ReplyDetail getReplyDetail(int commentId);


}
