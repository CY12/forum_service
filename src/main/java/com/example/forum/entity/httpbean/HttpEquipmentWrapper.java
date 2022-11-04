package com.example.forum.entity.httpbean;


/**
 * Copyright 2022 json.cn
 */


/**
 * Auto-generated: 2022-10-11 22:6:10
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
import java.util.List;
import java.util.Date;
public class HttpEquipmentWrapper {

    private List<Items> items;
    private String version;
    private String fileName;
    private Date fileTime;


    public void setItems(List<Items> items) {
        this.items = items;
    }
    public List<Items> getItems() {
        return items;
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