package com.project.adoption.pet.domain.spi;

import com.project.adoption.pet.domain.model.Adoption;

import java.util.List;

public interface IAdoptionPersistencePort {
    List<Adoption> getAdoptionsByEmail(String email);
    Long createAdoption(Adoption adoption);
    String updateAdoption(Long adoptionId, Adoption adoption);
    boolean deleteAdoption(Long adoptionId);
}
