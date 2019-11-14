package com.panev.heroes.web.models;

public class HeroCreateModel {

    private String name;
    private String gender;

    public HeroCreateModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
