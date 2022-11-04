package com.example.forum.service.heroservice;

import com.example.forum.entity.httpbean.BasicHeroData;

import java.util.List;

public interface BasicHeroDataService {
    int addBasicHeroData(BasicHeroData basicHeroData);

    int updateBasicHeroData(BasicHeroData basicHeroData);

    List<BasicHeroData> getAllBasicData();

}
