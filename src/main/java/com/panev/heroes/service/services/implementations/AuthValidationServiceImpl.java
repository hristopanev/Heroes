package com.panev.heroes.service.services.implementations;

import com.panev.heroes.data.repositrories.UsersRepository;
import com.panev.heroes.service.models.auth.RegisterUserServiceModel;
import com.panev.heroes.service.services.AuthValidationService;
import org.springframework.stereotype.Service;


@Service
public class AuthValidationServiceImpl implements AuthValidationService {

    private final UsersRepository usersRepository;

    public AuthValidationServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public boolean isValid(RegisterUserServiceModel registerUserServiceModel) {
        return
                this.isEmailValid(registerUserServiceModel.getEmail()) &&
                        this.arePasswordValid(registerUserServiceModel.getPassword(), registerUserServiceModel.getConfirmPassword()) &&
                        this.isUsernameFree(registerUserServiceModel.getUsername());
    }

    private boolean arePasswordValid(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }


    private boolean isUsernameFree(String username) {
        return !usersRepository.existsByUsername(username);
    }

    private boolean isEmailValid(String email) {
        return true;
    }
}
