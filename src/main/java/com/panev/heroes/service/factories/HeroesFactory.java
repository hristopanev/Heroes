package com.panev.heroes.service.factories;

import com.panev.heroes.data.models.Gender;
import com.panev.heroes.data.models.Hero;

public interface HeroesFactory {
    Hero create(String name, Gender gender);
}
