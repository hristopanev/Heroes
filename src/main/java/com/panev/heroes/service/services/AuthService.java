package com.panev.heroes.service.services;

import com.panev.heroes.service.models.LoginUserServiceModel;
import com.panev.heroes.service.models.auth.RegisterUserServiceModel;

public interface AuthService {

    void register(RegisterUserServiceModel model);

    LoginUserServiceModel login(RegisterUserServiceModel serviceModel) throws Exception;
}
