package com.example.forum.mapper.heromapper;

import com.example.forum.entity.HeroPlan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HeroPlanMapper {
    int addHeroPlan(HeroPlan heroPlan);

    List<HeroPlan> getHeroPlan(String heroId);

    int addUsedTimes(int id);
}
