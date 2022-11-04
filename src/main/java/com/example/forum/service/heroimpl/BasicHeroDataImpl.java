package com.example.forum.service.heroimpl;

import com.example.forum.entity.httpbean.BasicHeroData;
import com.example.forum.mapper.heromapper.BasicHeroDataMapper;
import com.example.forum.service.heroservice.BasicHeroDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicHeroDataImpl implements BasicHeroDataService {
    @Autowired
    BasicHeroDataMapper mapper;

    @Override
    public int addBasicHeroData(BasicHeroData basicHeroData) {
        return mapper.addBasicHeroData(basicHeroData);
    }

    @Override
    public int updateBasicHeroData(BasicHeroData basicHeroData) {
        return mapper.updateBasicHeroData(basicHeroData);
    }

    @Override
    public List<BasicHeroData> getAllBasicData() {
        return mapper.getAllBasicData();
    }
}
