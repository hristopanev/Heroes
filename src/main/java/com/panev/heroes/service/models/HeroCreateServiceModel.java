package com.panev.heroes.service.models;

import com.panev.heroes.data.models.Gender;

public class HeroCreateServiceModel {
    private String name;
    private Gender gender;

    public HeroCreateServiceModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
