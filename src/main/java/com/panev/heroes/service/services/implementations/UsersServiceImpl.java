package com.panev.heroes.service.services.implementations;

import com.panev.heroes.data.models.Hero;
import com.panev.heroes.data.models.User;
import com.panev.heroes.data.repositrories.UsersRepository;
import com.panev.heroes.service.models.HeroCreateServiceModel;
import com.panev.heroes.service.services.HeroesService;
import com.panev.heroes.service.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UserService {

    private final HeroesService heroesService;
    private final UsersRepository usersRepository;
    private final ModelMapper mapper;

    public UsersServiceImpl(HeroesService heroesService, UsersRepository usersRepository, ModelMapper mapper) {
        this.heroesService = heroesService;
        this.usersRepository = usersRepository;
        this.mapper = mapper;
    }

    @Override
    public void createHeroForUser(String username, HeroCreateServiceModel heroServiceModel) {
        User user = usersRepository.findByUsername(username);
        Hero hero = heroesService.create(heroServiceModel);
        user.setHero(hero);
        usersRepository.save(user);
    }
}