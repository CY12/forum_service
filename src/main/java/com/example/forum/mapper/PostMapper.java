package com.example.forum.mapper;

import com.example.forum.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PostMapper {

    int addPost(Post post);

    int deletePost(int id);

    int updatePost(Post post);

    Post getPost(int id);

    List<Post> getPostList(int start ,int size);

    List<Post> getPostByUser(int uid);

    int star (int id);

    int cancelStar(int id);

    int view(int id);

    int comment(int id);

    int cancelComment(int id);




}
