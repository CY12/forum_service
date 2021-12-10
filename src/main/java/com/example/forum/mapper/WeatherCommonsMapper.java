package com.example.forum.mapper;

import com.example.forum.entity.WeatherCommons;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface WeatherCommonsMapper {
    List<WeatherCommons> getWeatherCommons();
}
