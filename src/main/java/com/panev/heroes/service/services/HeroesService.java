package com.panev.heroes.service.services;

import com.panev.heroes.data.models.Hero;
import com.panev.heroes.service.models.HeroCreateServiceModel;
import com.panev.heroes.service.models.HeroDetailsServiceModel;

public interface HeroesService {
    HeroDetailsServiceModel getByName(String name);

    Hero create(HeroCreateServiceModel serviceModel);
}
