package com.panev.heroes.web.controllers;

import com.panev.heroes.errors.HeroNotFoundException;
import com.panev.heroes.service.models.HeroCreateServiceModel;
import com.panev.heroes.service.models.HeroDetailsServiceModel;
import com.panev.heroes.service.models.LoginUserServiceModel;
import com.panev.heroes.service.services.HeroesService;
import com.panev.heroes.service.services.UsersService;
import com.panev.heroes.web.models.HeroCreateModel;
import com.panev.heroes.web.models.HeroDetailsViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/heroes")
public class HeroesController {

    private final HeroesService heroesService;
    private final ModelMapper mapper;
    private final UsersService usersService;

    public HeroesController(HeroesService heroesService, ModelMapper mapper, UsersService usersService) {
        this.heroesService = heroesService;
        this.mapper = mapper;
        this.usersService = usersService;
    }

    @GetMapping("/details/{name}")
    public ModelAndView getHeroDetails(@PathVariable String name, ModelAndView modelAndView) {
        HeroDetailsServiceModel serviceModel = heroesService.getByName(name);
        HeroDetailsViewModel viewModel = mapper.map(serviceModel, HeroDetailsViewModel.class);
        modelAndView.addObject("hero", viewModel);
        modelAndView.setViewName("heroes/hero-details.html");
        return modelAndView;
    }

    @GetMapping("/create")
    public String getCreateHeroForm(HttpSession session) {
//        if(!isAuthenticated(session)) {
//            return "redirect:/users/login";
//        }
        return "heroes/create-hero.html";
    }

    @PostMapping("/create")
    public String createHero(@ModelAttribute HeroCreateModel hero, HttpSession session) {
//        if(!isAuthenticated(session)) {
//            return "/";
//        }

        String username = getUsername(session);

        HeroCreateServiceModel serviceModel = mapper.map(hero, HeroCreateServiceModel.class);
        try {
            usersService.createHeroForUser(username, serviceModel);
            LoginUserServiceModel loginUserServiceModel = new LoginUserServiceModel(username, hero.getName());
            session.setAttribute("user", loginUserServiceModel);
            return "redirect:/heroes/details/" + hero.getName();
        } catch (Exception ex) {
            return "redirect:/heroes/create";
        }
    }

    @ExceptionHandler(HeroNotFoundException.class)
    public ModelAndView handleException(HeroNotFoundException exception) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", exception.getMessage());

        return modelAndView;
    }
}
