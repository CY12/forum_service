package com.example.forum.service.heroservice;

import com.example.forum.entity.HeroPlan;

import java.util.List;

public interface HeroPlanService {
    int addHeroPlan(HeroPlan heroPlan);

    List<HeroPlan> getHeroPlan(int heroId);


}
