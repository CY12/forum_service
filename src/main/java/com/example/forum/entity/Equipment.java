package com.example.forum.entity;

import com.example.forum.entity.httpbean.Items;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Equipment {
    private String name;
    private String type = "";
    //暴击
    private double crit;
    //法强
    private double ap;
    //生命值
    private double hp;
    //法力值
    private double mana;
    //攻击力
    private double ad;
    //攻速
    private double as;
    //护甲
    private double armor;
    //魔抗
    private double mr;
    //移速
    private double speed;
    //穿透
    private double armorThroughPer;// 百分比穿透
    private double mrThroughPer;
    private double armorThroughNum;// 固定穿透
    private double mrThroughNum;

    //装备伤害

    private String desc;
    private String key;
    private String extraTitle;// 主动伤害
    private String extraDescList;// json
    private String img;
    public String equipmentType;// 神话 传说
    private String mythPassive;// 神话被动 json
    private String equipmentPassive;// 恶魔之拥 被动 2% 法强 json
    private String updateDate;


    public void copyFromHttpEquipment(Items items){
        this.name = items.getName();
        this.desc = items.getPlaintext();

        if (items.getDescription().contains("rarityMythic")){
            this.equipmentType = "myth";
            this.key = this.name;
        }else if (Integer.parseInt(items.getTotal()) > 2000){
            this.equipmentType = "length";
        }else if (Integer.parseInt(items.getTotal()) < 800){
            this.equipmentType = "simple";
        }else {
            this.equipmentType = "epic";
        }
        this.img = items.getIconPath();
        processAttr(items.getDescription());
    }

    private void processAttr(String attr){
        String[] strings = attr.split("attention");
        Map map = new HashMap();
        findNext(strings,1,true,0,map);
    }

    public  void findNext(String[] strings, int index, boolean isNum, double number, Map map){
        if (index >= strings.length) return;
        String s = strings[index];
        if (isNum){
            double per = 1;
            if (s.contains("%")){
                per = 0.01;
            }
            String numString = isNum(s);
            if (numString.length() > 0){
                Double num = Double.parseDouble(numString) * per;

                findNext(strings,index+1,false,num,map);
            }
        }else {
            String text =  s.substring(s.indexOf(">") + 1, s.indexOf("<"));
            process(text,number);
            map.put(text,number);
            findNext(strings,index+1,true,0,map);
        }


    }

    public  String isNum(String s){
        String regex = "[^0-9]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        String str = m.replaceAll("").trim();
        return str;
    }

    public void process(String target,double num){
        try {
            target = URLDecoder.decode(target,"utf-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("equipment process error "+e);
        }
        if (target.contains("攻击力")){
            this.ad = num;
            this.type = this.type+"ad,";
        }else if (target.contains("法术强度")){
            this.ap = num;
            this.type = this.type+ "ap,";
        }else if (target.contains("生命值")){
            this.hp = num;
            this.type = this.type+ "hp,";
        }else if (target.contains("护甲穿透")){
            this.armorThroughPer = num;
            this.type = this.type+ "armorT,";
        }else if (target.contains("法术穿透")){
            this.mrThroughPer = num;
            this.type = this.type+ "mrT,";
        }else if (target.contains("穿甲")){
            this.armorThroughNum = num;
            this.type = this.type+ "armorT,";
        }else if (target.contains("护甲")){
            this.armor = num;
            this.type = this.type+ "armor,";
        }else if (target.contains("魔法抗性")){
            this.mr = num;
            this.type = this.type+ "mr,";
        }else if (target.contains("移动速度")){
            this.speed = num;
            this.type = this.type+ "speed,";
        }else if (target.contains("暴击")){
            this.crit = num;
            this.type = this.type+ "crit,";
        }else if (target.contains("攻击速度")){
            this.as = num;
            this.type = this.type+ "as,";
        }else if (target.equals("法力")){
            this.mana = num;
            this.type = this.type+ "mana,";
        }else {
            System.out.println("unknown === "+target);
        }

    }
    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCrit() {
        return crit;
    }

    public void setCrit(double crit) {
        this.crit = crit;
    }

    public double getAp() {
        return ap;
    }

    public void setAp(double ap) {
        this.ap = ap;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public double getAd() {
        return ad;
    }

    public void setAd(double ad) {
        this.ad = ad;
    }

    public double getAs() {
        return as;
    }

    public void setAs(double as) {
        this.as = as;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public double getMr() {
        return mr;
    }

    public void setMr(double mr) {
        this.mr = mr;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getArmorThroughPer() {
        return armorThroughPer;
    }

    public void setArmorThroughPer(double armorThroughPer) {
        this.armorThroughPer = armorThroughPer;
    }

    public double getMrThroughPer() {
        return mrThroughPer;
    }

    public void setMrThroughPer(double mrThroughPer) {
        this.mrThroughPer = mrThroughPer;
    }

    public double getArmorThroughNum() {
        return armorThroughNum;
    }

    public void setArmorThroughNum(double armorThroughNum) {
        this.armorThroughNum = armorThroughNum;
    }

    public double getMrThroughNum() {
        return mrThroughNum;
    }

    public void setMrThroughNum(double mrThroughNum) {
        this.mrThroughNum = mrThroughNum;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getExtraTitle() {
        return extraTitle;
    }

    public void setExtraTitle(String extraTitle) {
        this.extraTitle = extraTitle;
    }

    public String getExtraDescList() {
        return extraDescList;
    }

    public void setExtraDescList(String extraDescList) {
        this.extraDescList = extraDescList;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getMythPassive() {
        return mythPassive;
    }

    public void setMythPassive(String mythPassive) {
        this.mythPassive = mythPassive;
    }

    public String getEquipmentPassive() {
        return equipmentPassive;
    }

    public void setEquipmentPassive(String equipmentPassive) {
        this.equipmentPassive = equipmentPassive;
    }
}
