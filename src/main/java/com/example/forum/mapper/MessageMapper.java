package com.example.forum.mapper;

import com.example.forum.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MessageMapper {
    int addMessage(Message message);

    int updateMessage(Message message);

    List<Message> getMessageList(int uid,int start,int size);

    List<Message> getNewMessage(int uid);

    int updateMessageReceive(int uid);

    int updateMessageRead(int id);
}
