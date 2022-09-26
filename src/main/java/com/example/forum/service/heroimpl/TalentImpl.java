package com.example.forum.service.heroimpl;


import com.example.forum.entity.Talent;
import com.example.forum.mapper.heromapper.TalentMapper;
import com.example.forum.service.heroservice.TalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalentImpl implements TalentService {

    @Autowired
    TalentMapper talentMapper;

    @Override
    public List<Talent> getAllTalent() {
        return talentMapper.getAllTalent();
    }

    @Override
    public int addTalent(Talent talent) {
        return talentMapper.addTalent(talent);
    }
}
