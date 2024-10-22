package com.project.pet.adoption.infrastructure.output.jpa.adapter;

import com.project.pet.adoption.common.util.Constants;
import com.project.pet.adoption.infrastructure.output.jpa.entity.AdoptionEntity;
import com.project.pet.adoption.infrastructure.output.jpa.mapper.IAdoptionEntityMapper;
import com.project.pet.adoption.domain.model.Adoption;
import com.project.pet.adoption.domain.spi.IAdoptionPersistencePort;
import com.project.pet.adoption.infrastructure.output.jpa.repository.IAdoptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@RequiredArgsConstructor
@Slf4j
public class AdoptionAdapter implements IAdoptionPersistencePort {
    private final IAdoptionRepository adoptionRepository;
    private final IAdoptionEntityMapper adoptionMapper;

    /**
     * @param email of user to get adoptions
     * @return list user adoptions
     */
    @Override
    public List<Adoption> getAdoptionsByEmail(String email) {
        return adoptionMapper.toAdoptionList(adoptionRepository.findByEmail(email));
    }

    /**
     * @param adoption to create
     * @return adoptionId of adoption created
     */
    @Override
    public Long createAdoption(Adoption adoption) {
        AdoptionEntity adoptionEntity = adoptionRepository.save(adoptionMapper.toAdoptionEntity(adoption));
        return adoptionEntity.getId();
    }

    /**
     * @param adoptionId of adoption to update
     * @param adoption data updated
     * @return message of successfully update
     */
    @Override
    public String updateAdoption(Long adoptionId, Adoption adoption) {
        AdoptionEntity adoptionEntity = adoptionRepository.findById(adoptionId).get();
        adoptionEntity.setDateAdoption(adoption.getDateAdoption());
        adoptionEntity.setEmail(adoption.getEmail());
        adoptionEntity.setPetId(adoption.getPetId());
        adoptionRepository.save(adoptionEntity);
        return String.format(Constants.MSG_ADOPTION_UPDATE_SUCCESSFULLY,String.valueOf(adoptionId));
    }

    /**
     * @param adoptionId of id to delete
     * @return boolean with the status of correct process
     */
    @Override
    public boolean deleteAdoption(Long adoptionId) {
        AdoptionEntity adoptionEntity = adoptionRepository.findById(adoptionId).get();
        adoptionEntity.setActive(Boolean.FALSE);
        adoptionRepository.save(adoptionEntity);
        return Boolean.TRUE;
    }
}
