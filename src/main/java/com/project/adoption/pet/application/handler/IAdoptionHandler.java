package com.project.adoption.pet.application.handler;

import com.project.adoption.pet.application.dto.AdoptionCreateResponse;
import com.project.adoption.pet.application.dto.AdoptionResponse;
import com.project.adoption.pet.application.dto.AdoptionUpdateResponse;
import com.project.adoption.pet.application.dto.CreateAdoptionRequest;
import com.project.adoption.pet.application.dto.DeleteAdoptionRequest;
import com.project.adoption.pet.application.dto.DeleteAdoptionResponse;
import com.project.adoption.pet.application.dto.UpdateAdoptionRequest;

import java.util.List;

public interface IAdoptionHandler {
    List<AdoptionResponse> getAdoptionsByEmail(String email);
    AdoptionCreateResponse createAdoption(CreateAdoptionRequest adoptionRequest);
    AdoptionUpdateResponse updateAdoption(UpdateAdoptionRequest adoptionRequest);
    DeleteAdoptionResponse deleteAdoption(DeleteAdoptionRequest adoptionRequest);

}
