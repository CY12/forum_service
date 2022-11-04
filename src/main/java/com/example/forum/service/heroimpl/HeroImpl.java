package com.example.forum.service.heroimpl;

import com.example.forum.entity.Hero;
import com.example.forum.mapper.heromapper.HeroMapper;
import com.example.forum.service.heroservice.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroImpl implements HeroService {

    @Autowired
    HeroMapper heroMapper;

    @Override
    public List<Hero> getAllHero() {
        return heroMapper.getAllHero();
    }

    @Override
    public List<Hero> getHero(int id) {
        return null;
    }

    @Override
    public int addHero(Hero hero) {
        return heroMapper.addHero(hero);
    }

    @Override
    public int updateHero(Hero hero) {
        int count = 0;
        try {
           count =  heroMapper.updateHero(hero);
        }catch (Exception e){
            System.out.println("error"+e);
        }
        return count;
    }
}
