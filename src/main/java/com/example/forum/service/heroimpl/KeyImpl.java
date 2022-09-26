package com.example.forum.service.heroimpl;

import com.example.forum.entity.Key;
import com.example.forum.mapper.heromapper.KeyMapper;
import com.example.forum.service.heroservice.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class KeyImpl implements KeyService {
    @Autowired
    KeyMapper keyMapper;

    @Override
    public int addKey(Key key) {
        return keyMapper.addKey(key);
    }

    @Override
    public int updateKey(Key key) {
        return 0;
    }

    @Override
    public Key getKey(String name,String desc) {
        if (name == null || name.length() == 0) return null;
        Key key = keyMapper.getKey(name);
        if (key == null){
            key = new Key();
            key.setKeyName(name);
            key.setDamageName(desc);
            addKey(key);
        }
        return key;
    }

    @Override
    public List<Key> getAllKey() {
        return keyMapper.getAllKey();
    }


}
