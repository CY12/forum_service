package com.example.forum.entity;


import com.example.forum.entity.httpbean.HttpHeroDetail;
import com.example.forum.entity.httpbean.Spells;

import java.util.List;

public class Hero {
    private int heroId;
    private String name;
    private String cname;
    private String img;
    private String type;// ad ap
    private String title;
    private String roles;
    private String desc;
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

    private String qName;
    private String wName;
    private String eName;
    private String rName;
    private String pName;
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

    public void copyFormHeroDetail(HttpHeroDetail heroDetail, List<Spells> spellsList){
        this.heroId = Integer.parseInt(heroDetail.getHeroId());
        this.name = heroDetail.getAlias();
        this.cname = heroDetail.getTitle();
        this.title = heroDetail.getName();
        this.img = "https://game.gtimg.cn/images/lol/act/img/champion/"+heroDetail.getAlias()+".png";
        if ("kMagic".equals(heroDetail.getDamageType())){
            this.type = "ap";

        }else {
            this.type = "ad";
        }
        String roles = "";
        for (String s: heroDetail.getRoles()){
            roles = roles + s+",";
        }
        this.roles = roles;
        this.desc = heroDetail.getShortBio();
        this.ar = Double.parseDouble(heroDetail.getAttackrange());
        this.originalHp = Double.parseDouble(heroDetail.getHp());
        this.perHp = Double.parseDouble(heroDetail.getHpperlevel());
        this.originalMana = Double.parseDouble(heroDetail.getMp());
        this.perMana = Double.parseDouble(heroDetail.getMpperlevel());
        this.originalAd = Double.parseDouble(heroDetail.getAttackdamage());
        this.perAd = Double.parseDouble(heroDetail.getAttackdamageperlevel());
        this.originalArmor = Double.parseDouble(heroDetail.getArmor());
        this.perArmor = Double.parseDouble(heroDetail.getArmorperlevel());
        this.originalMr = Double.parseDouble(heroDetail.getSpellblock());
        this.perMr = Double.parseDouble(heroDetail.getSpellblockperlevel());
        this.speed = Double.parseDouble(heroDetail.getMovespeed());
        for (Spells spells: spellsList){
            if (spells.getSpellKey().equals("q")){
                this.qName = spells.getName();
                this.skillQDesc = spells.getDescription();
                this.skillQJson = "{\"name\":\""+qName+"\",\"skillKey\":\""+heroDetail.getAlias()+"Q\"}";

            }else if (spells.getSpellKey().equals("w")){
                this.wName = spells.getName();
                this.skillWDesc = spells.getDescription();
                this.skillWJson = "{\"name\":\""+wName+"\",\"skillKey\":\""+heroDetail.getAlias()+"W\"}";

            }else if (spells.getSpellKey().equals("e")){
                this.eName = spells.getName();
                this.skillEDesc = spells.getDescription();
                this.skillEJson = "{\"name\":\""+eName+"\",\"skillKey\":\""+heroDetail.getAlias()+"E\"}";

            }else if (spells.getSpellKey().equals("r")){
                this.rName = spells.getName();
                this.skillRDesc = spells.getDescription();
                this.skillRJson = "{\"name\":\""+rName+"\",\"skillKey\":\""+heroDetail.getAlias()+"R\"}";

            }else if (spells.getSpellKey().equals("passive")){
                this.pName = spells.getName();
                this.skillPDesc = spells.getDescription();
                this.skillPJson = "{\"name\":\""+pName+"\",\"skillKey\":\""+heroDetail.getAlias()+"P\"}";

            }
        }

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getqName() {
        return qName;
    }

    public void setqName(String qName) {
        this.qName = qName;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
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
