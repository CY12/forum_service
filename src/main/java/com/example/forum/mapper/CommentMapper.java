package com.example.forum.mapper;

import com.example.forum.entity.Comment;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {

    int addComment(Comment comment);

    int deleteComment(int id);

    Comment getComment(int id);

    List<Comment> getCommentList(int postId, int start, int size);

    List<Comment> getCommentByUser(int uid);

    int reply(int id);

    int cancelReply(int id);

}
