package com.example.forum.mapper;

import com.example.forum.entity.Reply;
import com.example.forum.entity.ReplyDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReplyMapper {
    int addReply(Reply reply);

    List<Reply> getReplyList(int commentId);

    ReplyDetail getReplyDetail(int commentId);
}
