package com.example.forum.service.impl;

import com.example.forum.entity.Comment;
import com.example.forum.entity.Reply;
import com.example.forum.entity.ReplyDetail;
import com.example.forum.mapper.CommentMapper;
import com.example.forum.mapper.ReplyMapper;
import com.example.forum.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyImpl implements ReplyService {
    @Autowired
    ReplyMapper replyMapper;
    @Autowired
    CommentMapper commentMapper;


    @Override
    public int addReply(Reply reply) {
        return replyMapper.addReply(reply);
    }

    @Override
    public List<Reply> getReplyList(int commentId) {
        return replyMapper.getReplyList(commentId);
    }

    @Override
    public ReplyDetail getReplyDetail(int commentId) {
        ReplyDetail replyDetail = new ReplyDetail();
        Comment comment = commentMapper.getComment(commentId);
        if (comment != null){
            replyDetail.setComment(comment);
        }
        List<Reply> replyList = replyMapper.getReplyList(commentId);
        if (replyList.size() > 0){
            replyDetail.setReplyList(replyList);
        }
        return replyDetail;
    }
}
