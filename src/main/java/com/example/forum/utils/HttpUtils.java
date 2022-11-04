package com.example.forum.utils;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.forum.entity.*;
import com.example.forum.entity.httpbean.*;
import com.example.forum.service.heroservice.BasicHeroDataService;
import com.example.forum.service.heroservice.EquipmentService;
import com.example.forum.service.heroservice.HeroService;
import com.example.forum.service.heroservice.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class HttpUtils {

    private  static volatile HttpUtils instance;
    private static volatile int a = 53;


    @Autowired
    BasicHeroDataService basicHeroDataService;
    @Autowired
    HeroService  heroService;

    @Autowired
    KeyService keyService;

    @Autowired
    EquipmentService equipmentService;

    private static HttpUtils testUtil;
    @PostConstruct
    public void init(){
        testUtil = this;
    }

    public static void initHeroBasicData() {

        Mono<String> mono =
        WebClient.create("https://game.gtimg.cn/images/lol/act/img/js/heroList/hero_list.js")
                .get()
                .retrieve() // 获取响应体
                .bodyToMono(String.class);
        String s = mono.block();;
        System.out.println(s);
        try {
            s = URLDecoder.decode(s,"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        HeroWrapper heroWrapper = JSONUtil.toBean(s,HeroWrapper.class);
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                insertHeroTimer(heroWrapper.getHero(), heroWrapper.getVersion());
            }
        },0,5, TimeUnit.SECONDS);

    }

    public static void insertHeroTimer(List<HttpHero> list,String version){
        if (a < list.size()){
            HttpHero hero = list.get(a);
            System.out.println("insert"+hero.getName());
            insertHero(hero,version);
            a++;
        }


    }

    public  static void insertHero(HttpHero hero,String version){
        String url = "https://game.gtimg.cn/images/lol/act/img/js/hero/"+hero.getHeroId()+".js";
        Mono<String> mono =
                WebClient.create(url)
                        .get()
                        .retrieve() // 获取响应体
                        .bodyToMono(String.class);
        BasicHeroData heroData = new BasicHeroData();
        String s = mono.block();
        heroData.copyFromHttpHero(hero,version,s);
        System.out.println("get"+hero.getName());
        try {
            testUtil.basicHeroDataService.addBasicHeroData(heroData);
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }

    public void initHeroData(){
        List<BasicHeroData> list = testUtil.basicHeroDataService.getAllBasicData();
        List<Hero> heroes = testUtil.heroService.getAllHero();
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                insert2MyHero(list);
            }
        },0,300, TimeUnit.MILLISECONDS);
    }

//    private void insert2Key(List<Hero> list){
//        if (b < list.size()){
//            insertKey(list.get(b));
//            b++;
//        }
//    }

    private void insertKey(Hero hero){
        System.out.println("insert"+hero.getCname());

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
        try {
            testUtil.keyService.getOrAddKey(keyName,hero.getCname()+"Q");
            testUtil. keyService.getOrAddKey(keyNameW,hero.getCname()+"W");
            testUtil.keyService.getOrAddKey(keyNameE,hero.getCname()+"E");
            testUtil.keyService.getOrAddKey(keyNameR,hero.getCname()+"R");
            testUtil.keyService.getOrAddKey(keyNameP,hero.getCname()+"P");
        }catch (Exception e){
            System.out.println(e);
        }

    }


    private static volatile int b = 0;

    private void insert2MyHero(List<BasicHeroData> list){
       if (b < list.size()){
           String heroDetailJson = list.get(b).getHeroDetail();
           HeroDetailWrapper heroDetailWrapper = JSONUtil.toBean(heroDetailJson,HeroDetailWrapper.class);
           System.out.println("insert"+heroDetailWrapper.getHero().getName());
           realInsertMyHero(heroDetailWrapper);
           b++;
       }
    }

    private void realInsertMyHero(HeroDetailWrapper heroDetailWrapper){
        Hero hero = new Hero();
        hero.copyFormHeroDetail(heroDetailWrapper.getHero(),heroDetailWrapper.getSpells());
        insertKey(hero);
        if (hero.getTitle().equals("残月之肃")|| hero.getTitle().equals("影流之镰")){
            try {
                testUtil.heroService.addHero(hero);
            }catch (Exception e){
                System.out.println(e);
            }
        }

    }


    public void initEquipment(){
        String url = "https://game.gtimg.cn/images/lol/act/img/js/items/items.js?ts=2775820";
        Mono<String> mono =
                WebClient.create(url)
                        .get()
                        .retrieve() // 获取响应体
                        .bodyToMono(String.class);
        String s = mono.block();
        HttpEquipmentWrapper equipmentWrapper = JSONUtil.toBean(s,HttpEquipmentWrapper.class);
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                insertEquipment(equipmentWrapper.getItems());
            }
        },0,1, TimeUnit.SECONDS);
//        for (Items items : equipmentWrapper.getItems()){
//            Equipment equipment = new Equipment();
//            equipment.copyFromHttpEquipment(items);
//            if (equipment.getType().equals("myth")){
//                testUtil.keyService.getKey(equipment.getName(),equipment.getName());
//            }
//            testUtil.equipmentService.addEquipment(equipment);
//        }
    }

    private void insertEquipment(List<Items> items){
        if (b < items.size()){
            System.out.println("insert"+items.get(b).getName());
            Equipment equipment = new Equipment();
            equipment.copyFromHttpEquipment(items.get(b));
            if (equipment.getEquipmentType().equals("myth")){
                try {
                    testUtil.keyService.getOrAddKey(equipment.getName(),equipment.getName());
                }catch (Exception e){
                    System.out.println("add key error"+e);
                }

            }
            try {
                testUtil.equipmentService.addEquipment(equipment);
            }catch ( Exception e){
                System.out.println("add equipment error"+e);
            }
            b++;
        }

    }

// 85 87 88 105 106 151 160
    public   void addKey() {
        List<Hero> heroes = testUtil.heroService.getAllHero();
        b = 152;
//        insertKey(heroes);
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                insertKey(heroes);
            }
        },0,300, TimeUnit.MILLISECONDS);

    }

    private void insertKey(List<Hero> heroes){
        if (b < heroes.size()){
            Skill skill =JSONUtil.toBean( heroes.get(b).getSkillQJson(), Skill.class);
            Key key = translateToKey(heroes.get(b).getSkillQDesc());
            System.out.println("insert"+skill.getSkillKey());
            if (key != null){
                key.setKeyName(skill.getSkillKey());

                try{
                    testUtil.keyService.updateOrAddKey(key);
                }catch (Exception e){
                    System.out.println("insert key" +e);
                }


            }

            Skill skillw =JSONUtil.toBean( heroes.get(b).getSkillWJson(), Skill.class);
            Key keyw = translateToKey(heroes.get(b).getSkillWDesc());
            System.out.println("insert"+skillw.getSkillKey());
            if (keyw != null){
                keyw.setKeyName(skillw.getSkillKey());
                try{
                    testUtil.keyService.updateOrAddKey(keyw);
                }catch (Exception e){
                    System.out.println("insert key" +e);
                }
            }

            Skill skille =JSONUtil.toBean( heroes.get(b).getSkillEJson(), Skill.class);
            Key keye = translateToKey(heroes.get(b).getSkillEDesc());
            System.out.println("insert"+skille.getSkillKey());
            if (keye != null){
                keye.setKeyName(skille.getSkillKey());
                try{
                    testUtil.keyService.updateOrAddKey(keye);
                }catch (Exception e){
                    System.out.println("insert key" +e);
                }

            }

            Skill skillp =JSONUtil.toBean( heroes.get(b).getSkillPJson(), Skill.class);
            Key keyp = translateToKey(heroes.get(b).getSkillPDesc());
            System.out.println("insert"+skillp.getSkillKey());
            if (keyp != null){
                keyp.setKeyName(skillp.getSkillKey());
                try{
                    testUtil.keyService.updateOrAddKey(keyp);
                }catch (Exception e){
                    System.out.println("insert key" +e);
                }

            }

            Skill skillr =JSONUtil.toBean( heroes.get(b).getSkillRJson(), Skill.class);
            Key keyr = translateToKey(heroes.get(b).getSkillRDesc());
            System.out.println("insert"+skillr.getSkillKey());
            if (keyr != null){
                keyr.setKeyName(skillr.getSkillKey());
                try{
                    testUtil.keyService.updateOrAddKey(keyr);
                }catch (Exception e){
                    System.out.println("insert key" +e);
                }

            }
            b++;
        }
    }

    private Key translateToKey(String desc) {
        Key key = new Key();
        if (desc.contains("魔法伤害")){
            key.setDamageType("ap");
        }else if (desc.contains("物理伤害")){
            key.setDamageType("ad");
        }else if (desc.contains("真实伤害")){
            key.setDamageType("real");
        }
        List<SeniorDamage> seniorDamages = new ArrayList<>();
        key.setBasicDamage(getBasicDamage(desc));
        key.setSkillLevelDamage(getLevelDamage(key.getBasicDamage(),desc));
        key.setHeroLevelDamage(0);
        String[] split = desc.split("%");
        for (int i = 0; i < split.length - 1; i++) {

                SeniorDamage seniorDamage = new SeniorDamage();
                seniorDamage.setNumber(Double.parseDouble(getNumber(split[i]))*0.01);
                seniorDamage.setTarget(getTarget(split[i+1]));
                if (seniorDamage.getNumber() != 0 && seniorDamage.getTarget() != null){
                    seniorDamages.add(seniorDamage);
                }


        }

        String json = JSONUtil.toJsonStr(seniorDamages);
        key.setSeniorDamage(json);
        if (isGoodKey(key)){
            return key;
        }
        System.out.println("bad key"+" b=="+b);
        return null;
    }

    private boolean isGoodKey(Key key){
        if (key.getBasicDamage() != 0){
            return true;
        }
        return false;
    }

    private double getBasicDamage(String s){
        if(!s.contains("造") || !s.contains("/")){
            return 0;
        }
        s = s.substring(s.indexOf("造"));
        String num = "";
        try {
          num =  s.substring(s.indexOf("造")+1,s.indexOf("/"));
        }catch (Exception e){
            System.out.println(s+" "+e);
            num = "0";
        }
        num = getNumString(num);
        if (isNumeric1(num)){
            return Double.parseDouble(num);
        }else {
            return 0;
        }
    }

    private double getLevelDamage(double basicDamage,String s){
        if (basicDamage == 0) return 0;
        String num = s.substring(s.indexOf("/")+1,s.length());
        num = num.substring(0,num.indexOf("/"));

        if (isNumeric1(num)){
            return (Double.parseDouble(num) - basicDamage);
        }else {
            return 0;
        }
    }


    private String getNumString(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {

                str += s.charAt(i);

            }
        }
        return str;
    }

    public static boolean isNumeric1(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(Exception e){
            return false;
        }
    }


    private String getNumber(String s){
        if (s.contains("+")){
          return   getNumString(s.substring(s.indexOf("+")));
        }
        return "0";
    }

    private String getTarget(String s){
        if (s.contains("AP")){
            return "ap";
        }else if (s.contains("额外AD") || s.contains("额外物理伤害")){
            return "extraAd";
        }else if (s.contains("AD")){
            return "ad";
        }else if (s.contains("额外护甲")){
            return "extraArmor";
        }else if (s.contains("额外魔抗")){
            return "extraMr";
        }else if (s.contains("最大生命值")){
            return "eMaxHp";
        }else if (s.contains("当前生命值")){
            return "eNowHp";
        }else if (s.contains("已损失生命值")){
            return "eLossHp";
        }
        return null;
    }

}
