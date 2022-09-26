package com.example.forum.service.heroservice;

import com.example.forum.entity.Hero;
import com.example.forum.entity.Talent;

import java.util.List;

public interface TalentService {
    List<Talent> getAllTalent();

    int addTalent(Talent talent);

}
