package com.panev.heroes.service.services;

import com.panev.heroes.service.models.HeroCreateServiceModel;

public interface UserService {
    void createHeroForUser(String username, HeroCreateServiceModel hero);
}
