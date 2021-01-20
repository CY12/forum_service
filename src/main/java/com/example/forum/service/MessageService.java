package com.example.forum.service;

import com.example.forum.entity.Message;

import java.util.List;

public interface MessageService {
    int addMessage(Message message);

    int updateMessage(Message message);

    List<Message> getMessageList(int uid,int start, int size);

    List<Message> getNewMessage(int uid);

    int updateMessageReceive(int uid);

    int updateMessageRead(int id);
}
