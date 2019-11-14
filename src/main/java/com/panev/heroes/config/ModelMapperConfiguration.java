package com.panev.heroes.config;

import com.panev.heroes.data.models.Gender;
import com.panev.heroes.service.models.HeroCreateServiceModel;
import com.panev.heroes.web.models.HeroCreateModel;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {
    private static ModelMapper mapper;

    static {
        mapper = new ModelMapper();
        initMapper(mapper);
    }

    private static void initMapper(ModelMapper mapper) {
        Converter<String, Gender> stringToGenderConverter =
                ctx -> Gender.valueOf(ctx.getSource().toUpperCase());

        mapper.createTypeMap(HeroCreateModel.class, HeroCreateServiceModel.class)
                .addMappings(map -> map
                        .using(stringToGenderConverter)
                        .map(
                                HeroCreateModel::getGender,
                                HeroCreateServiceModel::setGender
                        )
                );
    }

    @Bean
    public ModelMapper modelMapper() {
        return mapper;
    }
}