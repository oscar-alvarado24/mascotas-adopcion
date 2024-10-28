package com.project.adoption.pet.application.mapper;

import com.google.protobuf.Timestamp;
import com.project.adoption.pet.application.dto.AdoptionCreateResponse;
import com.project.adoption.pet.application.dto.AdoptionResponse;
import com.project.adoption.pet.application.dto.AdoptionUpdateResponse;
import com.project.adoption.pet.application.dto.CreateAdoptionRequest;
import com.project.adoption.pet.application.dto.DeleteAdoptionResponse;
import com.project.adoption.pet.application.dto.MultipleEmailsResponse;
import com.project.adoption.pet.common.util.Constants;
import com.project.adoption.pet.domain.model.Adoption;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IAdoptionMapper {
    IAdoptionMapper INSTANCE = Mappers.getMapper(IAdoptionMapper.class);

    default AdoptionResponse toAdoptionResponse(List<Adoption> adoption, String email){
        if (adoption == null) return null;
        return AdoptionResponse.newBuilder()
                .setEmail(email)
                .addAllAdoptions(toAdoptionDtoList(adoption))
                .build();
    }
    List<com.project.adoption.pet.application.dto.AdoptionWithoutEmail> toAdoptionDtoList(List<Adoption> adoption);
    default com.project.adoption.pet.application.dto.AdoptionWithoutEmail toAdoptionWithoutEmail(Adoption adoption){
        if (adoption == null) return null;
        return com.project.adoption.pet.application.dto.AdoptionWithoutEmail.newBuilder()
                .setId(adoption.getId())
                .setPetId(adoption.getPetId())
                .setDateAdoption(localDateToTimestamp(adoption.getDateAdoption()))
                .build();
    }

    default Adoption toAdoptionModel(com.project.adoption.pet.application.dto.Adoption adoptionRequest){
        if(adoptionRequest == null) return null;
        Adoption adoption = new Adoption();
        adoption.setEmail(adoptionRequest.getEmail());
        adoption.setDateAdoption(timestampToLocalDate(adoptionRequest.getDateAdoption()));
        return adoption;
    }
    default Adoption toAdoptionModelFromCreateAdoptionRequest(CreateAdoptionRequest adoptionRequest){
        if(adoptionRequest == null) return null;
        Adoption adoption = new Adoption();
        adoption.setEmail(adoptionRequest.getEmail());
        adoption.setDateAdoption(timestampToLocalDate(adoptionRequest.getDateAdoption()));
        adoption.setPetId(adoptionRequest.getPetId());
        return adoption;
    }

    default AdoptionCreateResponse toAdoptionCreateResponse(Long adoptionId, String petId, String email) {
        return AdoptionCreateResponse.newBuilder().setId(adoptionId).setResponse(String.format(Constants.MSG_CREATE_ADOPTION_RESPONSE, petId, email)).build();
    }
    default AdoptionUpdateResponse toAdoptionUpdateResponse(String response) {
        return AdoptionUpdateResponse.newBuilder().setResponse(response).build();
    }
    default DeleteAdoptionResponse toDeleteAdoptionResponse(boolean response) {
        return DeleteAdoptionResponse.newBuilder().setSuccess(response).build();
    }
    // Convertir de Protobuf Timestamp a LocalDate
    default LocalDate timestampToLocalDate(Timestamp timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos());
        LocalDate time = instant.atZone(ZoneId.of("America/Bogota"))
                .toLocalDate();
        return time.plusDays(1L);
    }

    // Convertir de LocalDate a Protobuf Timestamp
    default Timestamp localDateToTimestamp(LocalDate localDate) {
        Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        return Timestamp.newBuilder()
                .setSeconds(instant.getEpochSecond())
                .setNanos(instant.getNano())
                .build();
    }

    default MultipleEmailsResponse toMultipleEmailsResponse(Map<String, List<Adoption>> adoptionsByEmails){
        List<AdoptionResponse> adoptionResponses = new ArrayList<>();
        adoptionsByEmails.forEach((email, adoptions) -> {
            AdoptionResponse adoptionResponse = AdoptionResponse.newBuilder()
                    .setEmail(email)
                    .addAllAdoptions(toAdoptionDtoList(adoptions))
                    .build();
            adoptionResponses.add(adoptionResponse);
        });
        return MultipleEmailsResponse.newBuilder()
                .addAllAdoptionResponses(adoptionResponses)
                .build();
    }
}
