package com.panev.heroes.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @OneToOne(mappedBy = "user")
    private Hero hero;

    public User() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Hero getHero() {
        return this.hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}