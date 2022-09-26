package com.example.forum.entity;

public class Talent {
    private String name;
    private String img;
    private String desc;
    private String key;
    private String type;// damage attr
    private double basic;
    private String basicType;
    private double heroLevelEach;
    private String extraTitle;

    private double inputNum;
    private String inputDesc;
    private double extraDamage;
    private String inputString;// delete todo
    private String updateDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public String getBasicType() {
        return basicType;
    }

    public void setBasicType(String basicType) {
        this.basicType = basicType;
    }

    public double getHeroLevelEach() {
        return heroLevelEach;
    }

    public void setHeroLevelEach(double heroLevelEach) {
        this.heroLevelEach = heroLevelEach;
    }

    public String getExtraTitle() {
        return extraTitle;
    }

    public void setExtraTitle(String extraTitle) {
        this.extraTitle = extraTitle;
    }

    public double getInputNum() {
        return inputNum;
    }

    public void setInputNum(double inputNum) {
        this.inputNum = inputNum;
    }

    public String getInputDesc() {
        return inputDesc;
    }

    public void setInputDesc(String inputDesc) {
        this.inputDesc = inputDesc;
    }

    public double getExtraDamage() {
        return extraDamage;
    }

    public void setExtraDamage(double extraDamage) {
        this.extraDamage = extraDamage;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
