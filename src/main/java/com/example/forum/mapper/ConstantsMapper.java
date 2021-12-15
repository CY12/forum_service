package com.example.forum.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ConstantsMapper {
    String getConstants(int type);
}
