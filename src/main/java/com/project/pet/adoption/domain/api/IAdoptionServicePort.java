package com.project.pet.adoption.domain.api;

import com.project.pet.adoption.domain.model.Adoption;
import com.project.pet.adoption.application.dto.AdoptionCreateResponse;
import com.project.pet.adoption.application.dto.CreateAdoptionRequest;
import com.project.pet.adoption.application.dto.DeleteAdoptionRequest;
import com.project.pet.adoption.application.dto.DeleteAdoptionResponse;
import com.project.pet.adoption.application.dto.UpdateAdoptionRequest;

import java.util.List;

public interface IAdoptionServicePort {
    List<Adoption> getAdoptionsByEmail(String email);
    Long createAdoption(Adoption adoption);
    String updateAdoption(Long adoptionId, Adoption adoption);
    boolean deleteAdoption(Long adoptionId);
}
