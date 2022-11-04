package com.example.forum.entity.httpbean;

/**
 * Copyright 2022 json.cn
 */
import java.util.List;

/**
 * Auto-generated: 2022-10-07 11:50:10
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class HttpHero {

    private String heroId;
    private String name;
    private String alias;
    private String title;
    private List<String> roles;
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
    public void setHeroId(String heroId) {
        this.heroId = heroId;
    }
    public String getHeroId() {
        return heroId;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    public String getAlias() {
        return alias;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
    public List<String> getRoles() {
        return roles;
    }

    public void setIsWeekFree(String isWeekFree) {
        this.isWeekFree = isWeekFree;
    }
    public String getIsWeekFree() {
        return isWeekFree;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }
    public String getAttack() {
        return attack;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }
    public String getDefense() {
        return defense;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }
    public String getMagic() {
        return magic;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public String getDifficulty() {
        return difficulty;
    }

    public void setSelectAudio(String selectAudio) {
        this.selectAudio = selectAudio;
    }
    public String getSelectAudio() {
        return selectAudio;
    }

    public void setBanAudio(String banAudio) {
        this.banAudio = banAudio;
    }
    public String getBanAudio() {
        return banAudio;
    }

    public void setIsARAMweekfree(String isARAMweekfree) {
        this.isARAMweekfree = isARAMweekfree;
    }
    public String getIsARAMweekfree() {
        return isARAMweekfree;
    }

    public void setIspermanentweekfree(String ispermanentweekfree) {
        this.ispermanentweekfree = ispermanentweekfree;
    }
    public String getIspermanentweekfree() {
        return ispermanentweekfree;
    }

    public void setChangeLabel(String changeLabel) {
        this.changeLabel = changeLabel;
    }
    public String getChangeLabel() {
        return changeLabel;
    }

    public void setGoldPrice(String goldPrice) {
        this.goldPrice = goldPrice;
    }
    public String getGoldPrice() {
        return goldPrice;
    }

    public void setCouponPrice(String couponPrice) {
        this.couponPrice = couponPrice;
    }
    public String getCouponPrice() {
        return couponPrice;
    }

    public void setCamp(String camp) {
        this.camp = camp;
    }
    public String getCamp() {
        return camp;
    }

    public void setCampId(String campId) {
        this.campId = campId;
    }
    public String getCampId() {
        return campId;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    public String getKeywords() {
        return keywords;
    }

    @Override
    public String toString() {
        return "HttpHero{" +
                "heroId='" + heroId + '\'' +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", title='" + title + '\'' +
                ", roles=" + roles +
                ", isWeekFree='" + isWeekFree + '\'' +
                ", attack='" + attack + '\'' +
                ", defense='" + defense + '\'' +
                ", magic='" + magic + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", selectAudio='" + selectAudio + '\'' +
                ", banAudio='" + banAudio + '\'' +
                ", isARAMweekfree='" + isARAMweekfree + '\'' +
                ", ispermanentweekfree='" + ispermanentweekfree + '\'' +
                ", changeLabel='" + changeLabel + '\'' +
                ", goldPrice='" + goldPrice + '\'' +
                ", couponPrice='" + couponPrice + '\'' +
                ", camp='" + camp + '\'' +
                ", campId='" + campId + '\'' +
                ", keywords='" + keywords + '\'' +
                '}';
    }
}