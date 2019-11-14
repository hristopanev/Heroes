package com.panev.heroes.data.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "items")
public class Item extends BaseEntity {

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private Slot slot;

    @Column
    private Integer stamina;

    @Column
    private Integer strength;

    @Column
    private Integer attack;

    @Column
    private Integer defence;

    @ManyToMany(mappedBy = "items")
    List<Hero> heroes;

    public Item() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Slot getSlot() {
        return this.slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Integer getStamina() {
        return this.stamina;
    }

    public void setStamina(Integer stamina) {
        this.stamina = stamina;
    }

    public Integer getStrength() {
        return this.strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getAttack() {
        return this.attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefence() {
        return this.defence;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }

    public List<Hero> getHeroes() {
        return this.heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }
}
