package com.example.forum.entity;

import java.util.List;

public class Equipment {
    private String name;
    private String type;
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
