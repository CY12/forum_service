package com.example.forum.entity.httpbean;

/**
 * Copyright 2022 json.cn
 */

import java.util.List;

/**
 * Auto-generated: 2022-10-07 15:11:23
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Spells {

    private String heroId;
    private String spellKey;
    private String name;
    private String description;
    private String abilityIconPath;
    private String abilityVideoPath;
    private String dynamicDescription;
    private List<String> cost;
    private String costburn;
    private List<String> cooldown;
    private String cooldownburn;
    private List<String> range;
    public void setHeroId(String heroId) {
        this.heroId = heroId;
    }
    public String getHeroId() {
        return heroId;
    }

    public void setSpellKey(String spellKey) {
        this.spellKey = spellKey;
    }
    public String getSpellKey() {
        return spellKey;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setAbilityIconPath(String abilityIconPath) {
        this.abilityIconPath = abilityIconPath;
    }
    public String getAbilityIconPath() {
        return abilityIconPath;
    }

    public void setAbilityVideoPath(String abilityVideoPath) {
        this.abilityVideoPath = abilityVideoPath;
    }
    public String getAbilityVideoPath() {
        return abilityVideoPath;
    }

    public void setDynamicDescription(String dynamicDescription) {
        this.dynamicDescription = dynamicDescription;
    }
    public String getDynamicDescription() {
        return dynamicDescription;
    }

    public void setCost(List<String> cost) {
        this.cost = cost;
    }
    public List<String> getCost() {
        return cost;
    }

    public void setCostburn(String costburn) {
        this.costburn = costburn;
    }
    public String getCostburn() {
        return costburn;
    }

    public void setCooldown(List<String> cooldown) {
        this.cooldown = cooldown;
    }
    public List<String> getCooldown() {
        return cooldown;
    }

    public void setCooldownburn(String cooldownburn) {
        this.cooldownburn = cooldownburn;
    }
    public String getCooldownburn() {
        return cooldownburn;
    }

    public void setRange(List<String> range) {
        this.range = range;
    }
    public List<String> getRange() {
        return range;
    }

}