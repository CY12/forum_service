package com.example.forum.mapper.heromapper;

import com.example.forum.entity.Equipment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EquipmentMapper {
    List<Equipment> getAllEquipment();

    int addEquipment(Equipment equipment);
}
