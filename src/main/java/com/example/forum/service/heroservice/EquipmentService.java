package com.example.forum.service.heroservice;

import com.example.forum.entity.Equipment;
import com.example.forum.entity.Talent;

import java.util.List;

public interface EquipmentService {
    List<Equipment> getAllEquipment();

    int addEquipment(Equipment equipment);
}
