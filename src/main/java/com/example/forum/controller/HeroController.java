package com.example.forum.controller;



import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.forum.bean.GameFlowerBean;
import com.example.forum.bean.Response;
import com.example.forum.entity.*;

import com.example.forum.service.ConstantsService;
import com.example.forum.service.heroservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class HeroController {
    @Autowired
    HeroService heroService;

    @Autowired
    TalentService talentService;

    @Autowired
    EquipmentService equipmentService;
    @Autowired
    HeroPlanService heroPlanService;

    @Autowired
    ConstantsService constantsService;

    @Autowired
    KeyService keyService;

    @PostMapping(value = "/addHero")
    public Response addHero(@RequestBody Hero hero){
        if (hero == null) {
            return Response.errorParams();
        }

        JSONObject jsonObject = JSONObject.parseObject(hero.getSkillQJson());
        String keyName = jsonObject.getString("skillKey");
        JSONObject jsonObjectW = JSONObject.parseObject(hero.getSkillWJson());
        String keyNameW = jsonObjectW.getString("skillKey");
        JSONObject jsonObjectE = JSONObject.parseObject(hero.getSkillEJson());
        String keyNameE = jsonObjectE.getString("skillKey");
        JSONObject jsonObjectR = JSONObject.parseObject(hero.getSkillRJson());
        String keyNameR = jsonObjectR.getString("skillKey");
        JSONObject jsonObjectP = JSONObject.parseObject(hero.getSkillPJson());
        String keyNameP = jsonObjectP.getString("skillKey");
        keyService.getKey(keyName,hero.getCname()+"Q");
        keyService.getKey(keyNameW,hero.getCname()+"W");
        keyService.getKey(keyNameE,hero.getCname()+"E");
        keyService.getKey(keyNameR,hero.getCname()+"R");
        keyService.getKey(keyNameP,hero.getCname()+"P");
        int count = heroService.addHero(hero);
        if ( count > 0){
            return Response.success();
        }
        return Response.error();
    }



    @PostMapping(value = "/updateHero")
    public Response updateHero(@RequestBody Hero hero){
        if (hero == null || hero.getId() == 0) {
            return Response.errorParams();
        }
        int count = heroService.updateHero(hero);
        if (count > 0){
            return Response.success();
        }
        return Response.error();
    }

    @PostMapping(value = "/getAllHero")
    public Response getAllHero(String version){
        if (version == null || version.length() == 0){
            return Response.getResponse(heroService.getAllHero());
        }
        String gameJson = constantsService.getConstants(2);
        GameFlowerBean gameFlower = JSONUtil.toBean(gameJson, GameFlowerBean.class);
        if (gameFlower == null) return Response.error("未找到版本信息");
        if (version.equals(gameFlower.getVersion())){
            return Response.success("是最新版本");
        }
        return Response.getResponse(heroService.getAllHero());
    }

    @PostMapping(value = "/addTalent")
    public Response addTalent(@RequestBody Talent talent){
        if (talent == null) {
            return Response.errorParams();
        }
        if (talent.getKey() != null && talent.getKey().length() > 0){
            keyService.getKey(talent.getKey(),talent.getName());
        }
        int count = talentService.addTalent(talent);
        if ( count > 0){
            return Response.success();
        }
        return Response.error();
    }

    @PostMapping(value = "/getAllTalent")
    public Response getAllTalent(String version){
        if (version == null || version.length() == 0){
            return Response.getResponse(talentService.getAllTalent());
        }
        String gameJson = constantsService.getConstants(2);
        GameFlowerBean gameFlower = JSONUtil.toBean(gameJson, GameFlowerBean.class);
        if (gameFlower == null) return Response.error("未找到版本信息");
        if (version.equals(gameFlower.getVersion())){
            return Response.success("是最新版本");
        }
        return Response.getResponse(talentService.getAllTalent());
    }

    @PostMapping(value = "/addEquipment")
    public Response addEquipment(@RequestBody Equipment equipment){
        if (equipment == null) {
            return Response.errorParams();
        }
        if (equipment.getKey() != null && equipment.getKey().length() > 0){
           keyService.getKey(equipment.getKey(),equipment.getName());
        }
        int count = equipmentService.addEquipment(equipment);
        if ( count > 0){
            return Response.success();
        }
        return Response.error();
    }

    @PostMapping(value = "/getAllEquipment")
    public Response getAllEquipment(String version){
        if (version == null || version.length() == 0){
            return Response.getResponse(equipmentService.getAllEquipment());
        }
        String gameJson = constantsService.getConstants(2);
        GameFlowerBean gameFlower = JSONUtil.toBean(gameJson, GameFlowerBean.class);
        if (gameFlower == null) return Response.error("未找到版本信息");
        if (version.equals(gameFlower.getVersion())){
            return Response.success("是最新版本");
        }
        return Response.getResponse(equipmentService.getAllEquipment());
    }


    @PostMapping(value = "/addHeroPlan")
    public Response addHeroPlan(@RequestBody HeroPlan heroPlan){
        if (heroPlan == null) {
            return Response.errorParams();
        }
        int count = heroPlanService.addHeroPlan(heroPlan);
        if ( count > 0){
            return Response.success();
        }
        return Response.error();
    }

    @PostMapping(value = "/getHeroPlan")
    public Response getAllHeroPlan(String heroName){

        return Response.getResponse(heroPlanService.getHeroPlan(heroName));
    }

    @PostMapping(value = "/usedHeroPlan")
    public Response usedHeroPlan(int id){

        return Response.getResponse(heroPlanService.addUsedTimes(id));
    }
}
