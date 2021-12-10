package com.example.forum.service.impl;

import com.example.forum.entity.WeatherCommons;
import com.example.forum.mapper.WeatherCommonsMapper;
import com.example.forum.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherImpl implements WeatherService {
    @Autowired
    WeatherCommonsMapper weatherCommonsMapper;

    @Override
    public List<WeatherCommons> getWeatherCommons() {

        return weatherCommonsMapper.getWeatherCommons();
    }
}
