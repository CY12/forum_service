package com.example.forum.entity.httpbean;

import java.util.List;

public class BasicHeroData {
    private String heroId;
    private String name;
    private String alias;
    private String title;
    private String roles;
    private String isWeekFree;
    private String attack;
    private String defense;
    private String magic;
    private String difficulty;
    private String selectAudio;
    private String banAudio;
    private String isARAMweekfree;
    private String ispermanentweekfree;
    private String changeLabel;
    private String goldPrice;
    private String couponPrice;
    private String camp;
    private String campId;
    private String keywords;
    private String version;
    private String heroDetail;

    public void copyFromHttpHero(HttpHero hero,String version,String heroDetail){
        this.heroId = hero.getHeroId();
        this.name = hero.getName();
        this.alias = hero.getAlias();
        this.title = hero.getTitle();
        String s  = "";
        for (String s1:hero.getRoles()){
            s = s+s1+",";
        }
        this.roles = s;
        this.isWeekFree = hero.getIsWeekFree();
        this.attack = hero.getAttack();
        this.defense = hero.getDefense();
        this.magic = hero.getMagic();
        this.difficulty = hero.getDifficulty();
        this.changeLabel = hero.getChangeLabel();
        this.goldPrice = hero.getGoldPrice();
        this.couponPrice = hero.getCouponPrice();
        this.camp = hero.getCamp();
        this.campId = hero.getCampId();
        this.keywords = hero.getKeywords();
        this.version = version;
        this.heroDetail = heroDetail;
    }

    public String getHeroId() {
        return heroId;
    }

    public void setHeroId(String heroId) {
        this.heroId = heroId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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

    public String getIsWeekFree() {
        return isWeekFree;
    }

    public void setIsWeekFree(String isWeekFree) {
        this.isWeekFree = isWeekFree;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public String getMagic() {
        return magic;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getSelectAudio() {
        return selectAudio;
    }

    public void setSelectAudio(String selectAudio) {
        this.selectAudio = selectAudio;
    }

    public String getBanAudio() {
        return banAudio;
    }

    public void setBanAudio(String banAudio) {
        this.banAudio = banAudio;
    }

    public String getIsARAMweekfree() {
        return isARAMweekfree;
    }

    public void setIsARAMweekfree(String isARAMweekfree) {
        this.isARAMweekfree = isARAMweekfree;
    }

    public String getIspermanentweekfree() {
        return ispermanentweekfree;
    }

    public void setIspermanentweekfree(String ispermanentweekfree) {
        this.ispermanentweekfree = ispermanentweekfree;
    }

    public String getChangeLabel() {
        return changeLabel;
    }

    public void setChangeLabel(String changeLabel) {
        this.changeLabel = changeLabel;
    }

    public String getGoldPrice() {
        return goldPrice;
    }

    public void setGoldPrice(String goldPrice) {
        this.goldPrice = goldPrice;
    }

    public String getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(String couponPrice) {
        this.couponPrice = couponPrice;
    }

    public String getCamp() {
        return camp;
    }

    public void setCamp(String camp) {
        this.camp = camp;
    }

    public String getCampId() {
        return campId;
    }

    public void setCampId(String campId) {
        this.campId = campId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHeroDetail() {
        return heroDetail;
    }

    public void setHeroDetail(String heroDetail) {
        this.heroDetail = heroDetail;
    }
}
