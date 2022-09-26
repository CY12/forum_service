package com.example.forum.entity;

public class Key {
    private String keyName;
    private String damageName;
    private String damageType;// ad ap real
    private double basicDamage;//40
    private String damageFrom;//  skill  equipment  passive a
    private String seniorDamage;
    private String buffs;

    private double skillLevelDamage;
    private double heroLevelDamage;
    private String updateDate;



    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getDamageName() {
        return damageName;
    }

    public void setDamageName(String damageName) {
        this.damageName = damageName;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public double getBasicDamage() {
        return basicDamage;
    }

    public void setBasicDamage(double basicDamage) {
        this.basicDamage = basicDamage;
    }

    public String getDamageFrom() {
        return damageFrom;
    }

    public void setDamageFrom(String damageFrom) {
        this.damageFrom = damageFrom;
    }

    public String getSeniorDamage() {
        return seniorDamage;
    }

    public void setSeniorDamage(String seniorDamage) {
        this.seniorDamage = seniorDamage;
    }

    public String getBuffs() {
        return buffs;
    }

    public void setBuffs(String buffs) {
        this.buffs = buffs;
    }



    public double getSkillLevelDamage() {
        return skillLevelDamage;
    }

    public void setSkillLevelDamage(double skillLevelDamage) {
        this.skillLevelDamage = skillLevelDamage;
    }

    public double getHeroLevelDamage() {
        return heroLevelDamage;
    }

    public void setHeroLevelDamage(double heroLevelDamage) {
        this.heroLevelDamage = heroLevelDamage;
    }
}
