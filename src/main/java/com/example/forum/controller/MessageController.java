package com.example.forum.controller;

import com.example.forum.bean.Response;
import com.example.forum.entity.Message;
import com.example.forum.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//@RequestMapping("/message")
@RestController
public class MessageController {
    @Autowired
    MessageService messageService;

//    int addMessage(Message message);
//
//    int updateMessage(Message message);
//
//    List<Message> getMessageList(int uid);

//    List<Message> getNewMessage(int uid);

    /**
     * 增加一条消息
     * @param message
     * @return
     */
    @PostMapping(value = "/addMessage")
    public Response addMessage(@RequestBody Message message){
        if (message == null){
            return Response.errorParams();
        }


        return Response.getResponse(messageService.addMessage(message));

    }

    /**
     * 更新消息
     * @param message
     * @return
     */
    @PostMapping(value = "/updateMessage")
    public Response updateMessage(@RequestBody Message message){
        if (message == null){
            return Response.errorParams();
        }
        return Response.getResponse(messageService.updateMessage(message));

    }

    @PostMapping(value = "/updateMessageReceive")
    public Response updateMessageReceive(int uid){
        if (uid == 0){
            return Response.errorParams();
        }
        return Response.getResponse(messageService.updateMessageReceive(uid));

    }

    @PostMapping(value = "/updateMessageRead")
    public Response updateMessageRead(int id){
        System.out.println("id"+id);
        return Response.getResponse(messageService.updateMessageRead(id));
    }

    /**
     * 获取消息
     * @param uid
     * @param start
     * @param size
     * @return
     */
    @PostMapping(value = "/getMessageList")
    public Response getMessageList(int uid,int start,int size){
        return Response.getResponse(messageService.getMessageList(uid,start,size));
    }

    /**
     * 获得新消息
     * @param uid
     * @return
     */
    @PostMapping(value = "/getNewMessage")
    public Response getNewMessage(int uid){
        return Response.getResponse(messageService.getNewMessage(uid));
    }



}
