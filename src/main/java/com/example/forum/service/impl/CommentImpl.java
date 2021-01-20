package com.example.forum.service.impl;

import com.example.forum.entity.Comment;
import com.example.forum.mapper.CommentMapper;
import com.example.forum.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public int addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    @Override
    public int deleteComment(int id) {
        return commentMapper.deleteComment(id);
    }

    @Override
    public Comment getComment(int id) {
        return commentMapper.getComment(id);
    }

    @Override
    public List<Comment> getCommentList(int postId, int start, int size) {
        return commentMapper.getCommentList(postId,start,size);
    }

    @Override
    public List<Comment> getCommentByUser(int uid) {
        return commentMapper.getCommentByUser(uid);
    }

    @Override
    public int reply(int id) {
        return commentMapper.reply(id);
    }

    @Override
    public int cancelReply(int id) {
        return commentMapper.cancelReply(id);
    }
}
