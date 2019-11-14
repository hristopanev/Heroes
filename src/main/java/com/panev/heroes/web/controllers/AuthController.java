package com.panev.heroes.web.controllers;

import com.panev.heroes.service.models.LoginUserServiceModel;
import com.panev.heroes.service.models.auth.RegisterUserServiceModel;
import com.panev.heroes.service.services.AuthService;
import com.panev.heroes.web.models.RegisterUserModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class AuthController {

    private final AuthService authService;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthController(AuthService authService, ModelMapper modelMapper) {
        this.authService = authService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "auth/login.html";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute RegisterUserModel model, HttpSession session) {
        RegisterUserServiceModel serviceModel = modelMapper.map(model, RegisterUserServiceModel.class);

        try {
            LoginUserServiceModel loginUserServiceModel = authService.login(serviceModel);
            session.setAttribute("user", loginUserServiceModel);
//            session.setAttribute("username", serviceModel.getUsername());
            return "redirect:/";
        } catch (Exception ex) {
            return "redirect:/users/login";
        }
    }

    @GetMapping("/register")
    public String getRegisterForm() {

        return "auth/register.html";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute RegisterUserModel model) {
        RegisterUserServiceModel serviceModel = modelMapper.map(model, RegisterUserServiceModel.class);
        authService.register(serviceModel);
        return "redirect:/";
    }
}
