package com.project.pet.adoption.infrastructure.configuration;

import com.project.pet.adoption.domain.api.IAdoptionServicePort;
import com.project.pet.adoption.domain.spi.IAdoptionPersistencePort;
import com.project.pet.adoption.domain.usecase.AdoptionUseCase;
import com.project.pet.adoption.infrastructure.input.grpc.AdoptionService;
import com.project.pet.adoption.infrastructure.output.jpa.adapter.AdoptionAdapter;
import com.project.pet.adoption.infrastructure.output.jpa.mapper.IAdoptionEntityMapper;
import com.project.pet.adoption.infrastructure.output.jpa.repository.IAdoptionRepository;
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
