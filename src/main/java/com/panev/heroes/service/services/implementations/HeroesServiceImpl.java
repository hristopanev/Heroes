package com.panev.heroes.service.services.implementations;

import com.panev.heroes.data.models.Hero;
import com.panev.heroes.data.models.Item;
import com.panev.heroes.data.models.Slot;
import com.panev.heroes.data.repositrories.HeroesRepository;
import com.panev.heroes.service.factories.HeroesFactory;
import com.panev.heroes.service.models.HeroCreateServiceModel;
import com.panev.heroes.service.models.HeroDetailsServiceModel;
import com.panev.heroes.service.models.HeroItemServiceModel;
import com.panev.heroes.service.services.HeroesService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroesServiceImpl implements HeroesService {
    private final HeroesRepository heroesRepository;
    private final HeroesFactory heroesFactory;
    private final ModelMapper mapper;

    public HeroesServiceImpl(HeroesRepository heroesRepository, HeroesFactory heroesFactory, ModelMapper mapper) {
        this.heroesRepository = heroesRepository;
        this.heroesFactory = heroesFactory;
        this.mapper = mapper;
    }

    @Override
    public HeroDetailsServiceModel getByName(String name) {
        Optional<Hero> heroOptional = heroesRepository.getByNameIgnoreCase(name);
        if (heroOptional.isEmpty()) {
            throw new NullPointerException("No such hero");
        }

        Hero hero = heroOptional.get();

        HeroDetailsServiceModel serviceModel = mapper.map(hero, HeroDetailsServiceModel.class);

        serviceModel.setWeapon(getItemBySlot(hero.getItems(), Slot.WEAPON));
        serviceModel.setGauntlets(getItemBySlot(hero.getItems(), Slot.GAUNTLETS));
        serviceModel.setHelmet(getItemBySlot(hero.getItems(), Slot.HELMET));
        serviceModel.setPads(getItemBySlot(hero.getItems(), Slot.PADS));
        serviceModel.setPauldrons(getItemBySlot(hero.getItems(), Slot.PAULDRON));

        return serviceModel;
    }

    @Override
    public Hero create(HeroCreateServiceModel serviceModel) {
        Hero hero = heroesFactory.create(serviceModel.getName(), serviceModel.getGender());
        heroesRepository.save(hero);
        return hero;
    }

    private HeroItemServiceModel getItemBySlot(List<Item> items, Slot slot) {
        Optional<Item> item = items
                .stream()
                .filter(x -> x.getSlot() == slot)
                .findFirst();

        return item.isPresent()
                ? mapper.map(item, HeroItemServiceModel.class)
                : null;
    }
}
