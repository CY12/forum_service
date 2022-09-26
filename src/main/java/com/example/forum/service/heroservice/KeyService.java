package com.example.forum.service.heroservice;

import com.example.forum.entity.Key;

import java.util.List;

public interface KeyService {
    int addKey(Key key);

    int updateKey(Key key);

    Key getKey(String name,String desc);

    List<Key> getAllKey();
}
