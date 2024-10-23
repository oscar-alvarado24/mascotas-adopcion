package com.project.adoption.pet.infrastructure.configuration;

import com.project.adoption.pet.domain.api.IAdoptionServicePort;
import com.project.adoption.pet.domain.spi.IAdoptionPersistencePort;
import com.project.adoption.pet.domain.usecase.AdoptionUseCase;
import com.project.adoption.pet.infrastructure.output.jpa.adapter.AdoptionAdapter;
import com.project.adoption.pet.infrastructure.output.jpa.mapper.IAdoptionEntityMapper;
import com.project.adoption.pet.infrastructure.output.jpa.repository.IAdoptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IAdoptionRepository adoptionRepository;
    private final IAdoptionEntityMapper adoptionEntityMapper;

    @Bean
    public IAdoptionPersistencePort adoptionPersistencePort() {
        return new AdoptionAdapter(adoptionRepository, adoptionEntityMapper);
    }

    @Bean
    public IAdoptionServicePort adoptionServicePort() {
        return new AdoptionUseCase(adoptionPersistencePort());
    }
}