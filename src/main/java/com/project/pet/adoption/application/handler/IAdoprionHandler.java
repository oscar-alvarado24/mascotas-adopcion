package com.project.pet.adoption.application.handler;

import com.project.pet.adoption.application.dto.Adoption;
import com.project.pet.adoption.application.dto.AdoptionCreateResponse;
import com.project.pet.adoption.application.dto.AdoptionResponse;
import com.project.pet.adoption.application.dto.AdoptionUpdateResponse;
import com.project.pet.adoption.application.dto.CreateAdoptionRequest;
import com.project.pet.adoption.application.dto.DeleteAdoptionRequest;
import com.project.pet.adoption.application.dto.DeleteAdoptionResponse;
import com.project.pet.adoption.application.dto.UpdateAdoptionRequest;
import io.grpc.internal.Stream;

import java.util.List;

public interface IAdoprionHandler {

    List<AdoptionResponse> getAdoptionsByEmail(String email);
    AdoptionCreateResponse createAdoption(CreateAdoptionRequest adoptionRequest);
    AdoptionUpdateResponse updateAdoption(UpdateAdoptionRequest adoptionRequest);
    DeleteAdoptionResponse deleteAdoption(DeleteAdoptionRequest adoptionRequest);
}
