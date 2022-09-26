package com.example.forum.service.heroservice;

import com.example.forum.entity.Hero;

import java.util.List;

public interface HeroService {
    List<Hero> getAllHero();

    List<Hero> getHero(int id);

    int addHero(Hero hero);

    int updateHero(Hero hero);
}
