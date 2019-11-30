package com.panev.heroes.service.services.implementations;

import com.panev.heroes.data.models.User;
import com.panev.heroes.data.repositrories.UsersRepository;
import com.panev.heroes.service.models.LoginUserServiceModel;
import com.panev.heroes.service.models.auth.RegisterUserServiceModel;
import com.panev.heroes.service.services.AuthService;
import com.panev.heroes.service.services.AuthValidationService;
import com.panev.heroes.service.services.HashingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthValidationService authValidationService;
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;
    private final HashingService hashingService;

    public AuthServiceImpl(AuthValidationService authValidationService, UsersRepository usersRepository,
                           ModelMapper modelMapper, HashingService hashingService) {

        this.authValidationService = authValidationService;
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
        this.hashingService = hashingService;
    }

    @Override
    public void register(RegisterUserServiceModel model) {
        if (!authValidationService.isValid(model)) {
            // do something
            return;
        }
        User user = modelMapper.map(model, User.class);
        user.setPassword(hashingService.hash(user.getPassword()));
        usersRepository.save(user);
    }


    @Override
    public LoginUserServiceModel login(RegisterUserServiceModel serviceModel) throws Exception {
        String passwordHash = hashingService.hash(serviceModel.getPassword());
        Optional<User> userOptional = usersRepository.findByUsernameAndPassword(serviceModel.getUsername(), passwordHash);
        if (userOptional.isEmpty()) {
            throw new  Exception("Invalid user");
        }

        User user = userOptional.get();
        String heroName = user.getHero() == null
                        ? null
                        :user.getHero().getName();
        return new  LoginUserServiceModel( serviceModel.getUsername(), heroName);
    }
}
