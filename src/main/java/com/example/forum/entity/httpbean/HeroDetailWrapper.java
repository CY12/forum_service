package com.example.forum.entity.httpbean;

/**
 * Copyright 2022 json.cn
 */

import java.util.List;
import java.util.Date;

/**
 * Auto-generated: 2022-10-07 15:11:23
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class HeroDetailWrapper
{

    private HttpHeroDetail hero;
    private List<Skins> skins;
    private List<Spells> spells;
    private String version;
    private String fileName;
    private Date fileTime;
    public void setHero(HttpHeroDetail hero) {
        this.hero = hero;
    }
    public HttpHeroDetail getHero() {
        return hero;
    }

    public void setSkins(List<Skins> skins) {
        this.skins = skins;
    }
    public List<Skins> getSkins() {
        return skins;
    }

    public void setSpells(List<Spells> spells) {
        this.spells = spells;
    }
    public List<Spells> getSpells() {
        return spells;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    public String getVersion() {
        return version;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFileName() {
        return fileName;
    }

    public void setFileTime(Date fileTime) {
        this.fileTime = fileTime;
    }
    public Date getFileTime() {
        return fileTime;
    }

}
