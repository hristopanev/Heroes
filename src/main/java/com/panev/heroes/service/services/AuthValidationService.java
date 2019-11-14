package com.panev.heroes.service.services;

import com.panev.heroes.service.models.auth.RegisterUserServiceModel;
import com.panev.heroes.web.models.RegisterUserModel;

public interface AuthValidationService {

    boolean isValid(RegisterUserServiceModel registerUserServiceModel);
}
