package com.example.forum.mapper.heromapper;

import com.example.forum.entity.httpbean.BasicHeroData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BasicHeroDataMapper {
    int addBasicHeroData(BasicHeroData basicHeroData);

    int updateBasicHeroData(BasicHeroData basicHeroData);

    List<BasicHeroData> getAllBasicData();
}
