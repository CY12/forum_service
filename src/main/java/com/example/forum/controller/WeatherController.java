package com.example.forum.controller;

import com.example.forum.bean.Response;
import com.example.forum.entity.ImageSquare;
import com.example.forum.service.ImageSquareService;
import com.example.forum.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;
    @Autowired
    ImageSquareService imageSquareService;


    @PostMapping("/getWeatherCommons")
    public Response getWeatherCommons(){
        return Response.getResponse(weatherService.getWeatherCommons());
    }

    @PostMapping("/getSquareImage")
    public Response getSquareImage(int start,int size,int type){
        return Response.getResponse(imageSquareService.getImageSquare(start,size,type));
    }

    @PostMapping("/addSquareImage")
    public Response addSquareImage(String imgSquareJson, List<MultipartFile> files){
        return Response.getResponse(imageSquareService.addImageSquare(imgSquareJson,files));
    }
}
