package com.example.forum.mapper.heromapper;


import com.example.forum.entity.Hero;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HeroMapper {

    List<Hero> getAllHero();

    List<Hero> getHero(int id);

    int addHero(Hero hero);

    int updateHero(Hero hero);

}
