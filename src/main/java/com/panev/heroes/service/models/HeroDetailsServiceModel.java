package com.panev.heroes.service.models;

import com.panev.heroes.data.models.Gender;

public class HeroDetailsServiceModel {
    private String name;
    private Gender gender;
    private int level;
    private int stamina;
    private int strength;
    private int attack;
    private int defence;

    private HeroItemServiceModel weapon;
    private HeroItemServiceModel pads;
    private HeroItemServiceModel gauntlets;
    private HeroItemServiceModel pauldrons;
    private HeroItemServiceModel helmet;

    public HeroDetailsServiceModel() {
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

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStamina() {
        return this.stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return this.defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public HeroItemServiceModel getWeapon() {
        return this.weapon;
    }

    public void setWeapon(HeroItemServiceModel weapon) {
        this.weapon = weapon;
    }

    public HeroItemServiceModel getPads() {
        return this.pads;
    }

    public void setPads(HeroItemServiceModel pads) {
        this.pads = pads;
    }

    public HeroItemServiceModel getGauntlets() {
        return this.gauntlets;
    }

    public void setGauntlets(HeroItemServiceModel gauntlets) {
        this.gauntlets = gauntlets;
    }

    public HeroItemServiceModel getPauldrons() {
        return this.pauldrons;
    }

    public void setPauldrons(HeroItemServiceModel pauldrons) {
        this.pauldrons = pauldrons;
    }

    public HeroItemServiceModel getHelmet() {
        return this.helmet;
    }

    public void setHelmet(HeroItemServiceModel helmet) {
        this.helmet = helmet;
    }
}
