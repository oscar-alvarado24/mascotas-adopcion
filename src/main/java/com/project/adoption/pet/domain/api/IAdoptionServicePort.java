package com.project.adoption.pet.domain.api;

import com.project.adoption.pet.domain.model.Adoption;

import java.util.List;

public interface IAdoptionServicePort {
    List<Adoption> getAdoptionsByEmail(String email);
    Long createAdoption(Adoption adoption);
    String updateAdoption(Long adoptionId, Adoption adoption);
    boolean deleteAdoption(Long adoptionId);
}
