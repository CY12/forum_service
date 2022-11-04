package com.example.forum.entity.httpbean;

/**
 * Copyright 2022 json.cn
 */

import java.util.List;
import java.util.Date;

/**
 * Auto-generated: 2022-10-07 14:56:41
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class HeroWrapper {

    private List<HttpHero> hero;
    private String version;
    private String fileName;
    private Date fileTime;
    public void setHero(List<HttpHero> hero) {
        this.hero = hero;
    }
    public List<HttpHero> getHero() {
        return hero;
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
