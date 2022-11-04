package com.example.forum.service.heroservice;

import com.example.forum.entity.Key;

import java.util.List;

public interface KeyService {
    int addKey(Key key);

    int updateOrAddKey(Key key);

    Key getOrAddKey(String name, String desc);

    Key getKey(String name);

    List<Key> getAllKey();
}
