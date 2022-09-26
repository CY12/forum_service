package com.example.forum.mapper.heromapper;


import com.example.forum.entity.Key;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface KeyMapper {
    int addKey(Key key);

    int updateKey(Key key);

    Key getKey(String name);

    List<Key> getAllKey();
}
