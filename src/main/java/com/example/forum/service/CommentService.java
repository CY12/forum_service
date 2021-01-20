package com.example.forum.service;

import com.example.forum.entity.Comment;

import java.util.List;

public interface CommentService {

    int addComment(Comment comment);

    int deleteComment(int id);

    Comment getComment(int id);

    List<Comment> getCommentList(int postId, int start, int size);

    List<Comment> getCommentByUser(int uid);

    int reply(int id);

    int cancelReply(int id);
}
