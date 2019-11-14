package com.panev.heroes.data.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "heroes")
public class Hero extends BaseEntity {
    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

    @Column
    private int level;

    @Column
    private int stamina;

    @Column
    private int strength;

    @Column
    private int attack;

    @Column
    private int defence;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "hero_items",
            joinColumns = {@JoinColumn(name = "hero_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")}
    )
    private List<Item> items;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Hero() {
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

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
