package com.example.forum.service.heroimpl;


import com.example.forum.entity.Equipment;
import com.example.forum.mapper.heromapper.EquipmentMapper;
import com.example.forum.service.heroservice.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentImpl implements EquipmentService {

    @Autowired
    EquipmentMapper equipmentMapper;

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentMapper.getAllEquipment();
    }

    @Override
    public int addEquipment(Equipment equipment) {
        return equipmentMapper.addEquipment(equipment);
    }

    @Override
    public int updateEquipment(Equipment equipment) {
        return equipmentMapper.updateEquipment(equipment);
    }
}
