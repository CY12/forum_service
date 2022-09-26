package com.example.forum.entity;


public class Hero {
    private int id;
    private String name;
    private String cname;
    private String img;
    private String type;// ad ap
    //射程
    private double ar;
    //暴击
    private double crit;
    private double ap;
    //生命值
    private double hp;
    private double perHp;
    private double originalHp;
    //法力值
    private double mana;
    private double perMana;
    private double originalMana;
    //攻击力
    private double ad;
    private double perAd;
    private double originalAd;
    //攻速
    private double as;
    private double perAs;
    private double originalAs;
    //护甲
    private double armor;
    private double perArmor;
    private double originalArmor;
    //魔抗
    private double mr;
    private double perMr;
    private double originalMr;
    //移速
    private double speed;
    private int date;
    private int where;

    private String skillQDesc;
    private String skillQJson;
    private String skillWDesc;
    private String skillWJson;
    private String skillEDesc;
    private String skillEJson;
    private String skillRDesc;
    private String skillRJson;
    private String skillPDesc;
    private String skillPJson;

    private int version;
    private String updateDate;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getAr() {
        return ar;
    }

    public void setAr(double ar) {
        this.ar = ar;
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

    public double getPerHp() {
        return perHp;
    }

    public void setPerHp(double perHp) {
        this.perHp = perHp;
    }

    public double getOriginalHp() {
        return originalHp;
    }

    public void setOriginalHp(double originalHp) {
        this.originalHp = originalHp;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public double getPerMana() {
        return perMana;
    }

    public void setPerMana(double perMana) {
        this.perMana = perMana;
    }

    public double getOriginalMana() {
        return originalMana;
    }

    public void setOriginalMana(double originalMana) {
        this.originalMana = originalMana;
    }

    public double getAd() {
        return ad;
    }

    public void setAd(double ad) {
        this.ad = ad;
    }

    public double getPerAd() {
        return perAd;
    }

    public void setPerAd(double perAd) {
        this.perAd = perAd;
    }

    public double getOriginalAd() {
        return originalAd;
    }

    public void setOriginalAd(double originalAd) {
        this.originalAd = originalAd;
    }

    public double getAs() {
        return as;
    }

    public void setAs(double as) {
        this.as = as;
    }

    public double getPerAs() {
        return perAs;
    }

    public void setPerAs(double perAs) {
        this.perAs = perAs;
    }

    public double getOriginalAs() {
        return originalAs;
    }

    public void setOriginalAs(double originalAs) {
        this.originalAs = originalAs;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public double getPerArmor() {
        return perArmor;
    }

    public void setPerArmor(double perArmor) {
        this.perArmor = perArmor;
    }

    public double getOriginalArmor() {
        return originalArmor;
    }

    public void setOriginalArmor(double originalArmor) {
        this.originalArmor = originalArmor;
    }

    public double getMr() {
        return mr;
    }

    public void setMr(double mr) {
        this.mr = mr;
    }

    public double getPerMr() {
        return perMr;
    }

    public void setPerMr(double perMr) {
        this.perMr = perMr;
    }

    public double getOriginalMr() {
        return originalMr;
    }

    public void setOriginalMr(double originalMr) {
        this.originalMr = originalMr;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getWhere() {
        return where;
    }

    public void setWhere(int where) {
        this.where = where;
    }

    public String getSkillQDesc() {
        return skillQDesc;
    }

    public void setSkillQDesc(String skillQDesc) {
        this.skillQDesc = skillQDesc;
    }

    public String getSkillQJson() {
        return skillQJson;
    }

    public void setSkillQJson(String skillQJson) {
        this.skillQJson = skillQJson;
    }

    public String getSkillWDesc() {
        return skillWDesc;
    }

    public void setSkillWDesc(String skillWDesc) {
        this.skillWDesc = skillWDesc;
    }

    public String getSkillWJson() {
        return skillWJson;
    }

    public void setSkillWJson(String skillWJson) {
        this.skillWJson = skillWJson;
    }

    public String getSkillEDesc() {
        return skillEDesc;
    }

    public void setSkillEDesc(String skillEDesc) {
        this.skillEDesc = skillEDesc;
    }

    public String getSkillEJson() {
        return skillEJson;
    }

    public void setSkillEJson(String skillEJson) {
        this.skillEJson = skillEJson;
    }

    public String getSkillRDesc() {
        return skillRDesc;
    }

    public void setSkillRDesc(String skillRDesc) {
        this.skillRDesc = skillRDesc;
    }

    public String getSkillRJson() {
        return skillRJson;
    }

    public void setSkillRJson(String skillRJson) {
        this.skillRJson = skillRJson;
    }

    public String getSkillPDesc() {
        return skillPDesc;
    }

    public void setSkillPDesc(String skillPDesc) {
        this.skillPDesc = skillPDesc;
    }

    public String getSkillPJson() {
        return skillPJson;
    }

    public void setSkillPJson(String skillPJson) {
        this.skillPJson = skillPJson;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cName) {
        this.cname = cName;
    }


}
