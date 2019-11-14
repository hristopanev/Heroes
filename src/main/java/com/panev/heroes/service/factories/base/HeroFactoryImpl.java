package com.panev.heroes.service.factories.base;

import com.panev.heroes.data.models.Gender;
import com.panev.heroes.data.models.Hero;
import com.panev.heroes.service.factories.HeroesFactory;
import org.springframework.stereotype.Service;

@Service
public class HeroFactoryImpl implements HeroesFactory {

    @Override
    public Hero create(String name, Gender gender) {
        Hero hero = new Hero();
        hero.setName(name);
        hero.setGender(gender);
        hero.setAttack(1);
        hero.setDefence(1);
        hero.setLevel(1);
        hero.setStamina(1);
        hero.setStrength(1);
        return hero;
    }
}
