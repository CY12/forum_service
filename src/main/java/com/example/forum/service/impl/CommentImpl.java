package com.example.forum.service.impl;

import com.example.forum.entity.Comment;
import com.example.forum.mapper.CommentMapper;
import com.example.forum.service.CommentService;
import com.example.forum.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    FileService fileService;

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
        List<Comment> comments = commentMapper.getCommentList(postId,start,size);
       for (int i=0;i<comments.size();i++){
           List<String> urls = new ArrayList<>();
           if (comments.get(i).getImage()>0){
                urls = fileService.getImage(3,comments.get(i).getId());

           }
           comments.get(i).setUrlList(urls);
       }
        return comments;
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
