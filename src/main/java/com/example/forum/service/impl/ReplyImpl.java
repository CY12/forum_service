package com.example.forum.service.impl;

import cn.hutool.json.JSONUtil;
import com.example.forum.bean.Id;
import com.example.forum.bean.Response;
import com.example.forum.entity.Comment;
import com.example.forum.entity.Reply;
import com.example.forum.entity.ReplyDetail;
import com.example.forum.mapper.CommentMapper;
import com.example.forum.mapper.ReplyMapper;
import com.example.forum.service.CommentService;
import com.example.forum.service.FileService;
import com.example.forum.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReplyImpl implements ReplyService {
    @Autowired
    ReplyMapper replyMapper;
    @Autowired
    CommentService commentService;
    @Autowired
    FileService fileService;



    @Override
    public int addReply(Reply reply) {
        return replyMapper.addReply(reply);
    }

    @Override
    public Response addImageReply(List<MultipartFile> multipartFiles,int type, String reply) {
        Id id = new Id();
        if (type == FileService.IMG_REPLY){
            Reply reply1 = JSONUtil.toBean(reply,Reply.class);
            int count = addReply(reply1);
            if (count == 0){
                return Response.error("回复失败");
            }
            int error = fileService.uploadImage(multipartFiles,FileService.IMG_REPLY,reply1.getId());
            if (error > 0){
                return Response.error("图片上传失败");
            }
            id.setId(reply1.getId());
            return Response.success(id);
        }else if (type == FileService.IMG_COMMENT){
            Comment comment = JSONUtil.toBean(reply,Comment.class);
            int count = commentService.addComment(comment);
            if (count == 0){
                return Response.error("评论失败");
            }
            int error = fileService.uploadImage(multipartFiles,FileService.IMG_COMMENT,comment.getId());
            if (error > 0){
                return Response.error("图片上传失败");
            }
            id.setId(comment.getId());
            return Response.success(id);

        }
       return Response.errorParams();
    }

    @Override
    public List<Reply> getReplyList(int commentId) {
        List<Reply> replyList = replyMapper.getReplyList(commentId);
        for (int i = 0 ;i<replyList.size();i++){
            List<String> urls = new ArrayList<>();
            if (replyList.get(i).getImage()>0){
                urls = fileService.getImage(FileService.IMG_REPLY,replyList.get(i).getId());
            }
            replyList.get(i).setUrlList(urls);
        }
        return replyList;
    }

    @Override
    public ReplyDetail getReplyDetail(int commentId) {
        ReplyDetail replyDetail = new ReplyDetail();
        Comment comment = commentService.getComment(commentId);
        if (comment != null){
            replyDetail.setComment(comment);
        }
        List<Reply> replyList = getReplyList(commentId);
        if (replyList.size() > 0){
            replyDetail.setReplyList(replyList);
        }
        return replyDetail;
    }


}
