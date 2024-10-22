package com.project.pet.adoption.infrastructure.output.jpa.mapper;

import com.project.pet.adoption.application.mapper.IAdoptionMapper;
import com.project.pet.adoption.domain.model.Adoption;
import com.project.pet.adoption.infrastructure.output.jpa.entity.AdoptionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IAdoptionEntityMapper {
    IAdoptionEntityMapper INSTANCE = Mappers.getMapper(IAdoptionEntityMapper.class);
    AdoptionEntity toAdoptionEntity (Adoption adoption);
    Adoption toAdoption(AdoptionEntity adoptionEntity);
    List<AdoptionEntity> toAdoptionEntityList (List<Adoption> adoption);
    List<Adoption> toAdoptionList(List<AdoptionEntity> adoptionEntity);
}
