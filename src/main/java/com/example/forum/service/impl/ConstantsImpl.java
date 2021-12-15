package com.example.forum.service.impl;

import com.example.forum.mapper.ConstantsMapper;
import com.example.forum.service.ConstantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstantsImpl implements ConstantsService {

    @Autowired
    ConstantsMapper mapper;

    @Override
    public String getConstants(int type) {
        return mapper.getConstants(type);
    }
}
