package com.project.adoption.pet.domain.api;

import com.project.adoption.pet.domain.model.Adoption;

import java.util.List;
import java.util.Map;

public interface IAdoptionServicePort {
    List<Adoption> getAdoptionsByEmail(String email);
    Long createAdoption(Adoption adoption);
    String updateAdoption(Long adoptionId, Adoption adoption);
    boolean deleteAdoption(Long adoptionId);
    Map<String,List<Adoption>> getAdoptionsByEmails(List<String> emails);
}
