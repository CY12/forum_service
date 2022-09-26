package com.example.forum.service.heroimpl;


import com.example.forum.entity.HeroPlan;
import com.example.forum.mapper.heromapper.HeroPlanMapper;
import com.example.forum.service.heroservice.HeroPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroPlanImpl implements HeroPlanService {
    @Autowired
    HeroPlanMapper heroPlanMapper;

    @Override
    public int addHeroPlan(HeroPlan heroPlan) {
        return heroPlanMapper.addHeroPlan(heroPlan);
    }

    @Override
    public List<HeroPlan> getHeroPlan(int heroId) {
        return heroPlanMapper.getHeroPlan(heroId);
    }
}
