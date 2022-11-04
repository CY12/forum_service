package com.example.forum.entity.httpbean;

/**
 * Copyright 2022 json.cn
 */

import com.example.forum.entity.Equipment;

import java.util.List;

/**
 * Auto-generated: 2022-10-11 22:6:10
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Items {

    private String itemId;
    private String name;
    private String iconPath;
    private String price;
    private String description;
    private List<String> maps;
    private String plaintext;
    private String sell;
    private String total;
    private List<String> into;

    private String suitHeroId;
    private String tag;
    private List<String> types;
    private String keywords;



    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public String getItemId() {
        return itemId;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }
    public String getIconPath() {
        return iconPath;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setMaps(List<String> maps) {
        this.maps = maps;
    }
    public List<String> getMaps() {
        return maps;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }
    public String getPlaintext() {
        return plaintext;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }
    public String getSell() {
        return sell;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    public String getTotal() {
        return total;
    }

    public void setInto(List<String> into) {
        this.into = into;
    }
    public List<String> getInto() {
        return into;
    }



    public void setSuitHeroId(String suitHeroId) {
        this.suitHeroId = suitHeroId;
    }
    public String getSuitHeroId() {
        return suitHeroId;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getTag() {
        return tag;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
    public List<String> getTypes() {
        return types;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    public String getKeywords() {
        return keywords;
    }

}
