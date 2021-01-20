package com.example.forum.service.impl;

import com.example.forum.entity.Message;
import com.example.forum.mapper.MessageMapper;
import com.example.forum.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;


    @Override
    public int addMessage(Message message) {
        return messageMapper.addMessage(message);
    }

    @Override
    public int updateMessage(Message message) {
        return messageMapper.updateMessage(message);
    }

    @Override
    public List<Message> getMessageList(int uid,int start,int size) {
        return messageMapper.getMessageList(uid,start,size);
    }

    @Override
    public List<Message> getNewMessage(int uid) {
        return messageMapper.getNewMessage(uid);
    }

    @Override
    public int updateMessageReceive(int uid) {
        return messageMapper.updateMessageReceive(uid);
    }

    @Override
    public int updateMessageRead(int id) {
        return messageMapper.updateMessageRead(id);
    }
}
