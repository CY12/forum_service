package com.example.forum.mapper.heromapper;

import com.example.forum.entity.Talent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface TalentMapper {
    List<Talent> getAllTalent();

    int addTalent(Talent talent);
}
