package com.project.adoption.pet.domain.usecase;

import com.project.adoption.pet.domain.api.IAdoptionServicePort;
import com.project.adoption.pet.domain.model.Adoption;
import com.project.adoption.pet.domain.spi.IAdoptionPersistencePort;

import java.util.List;
import java.util.Map;

public class AdoptionUseCase implements IAdoptionServicePort {

    private final IAdoptionPersistencePort adoptionPersistencePort;

    public AdoptionUseCase(IAdoptionPersistencePort adoptionPersistencePort) {
        this.adoptionPersistencePort = adoptionPersistencePort;
    }

    /**
     * @param email of user to get adoptions
     * @return list of user adoption
     */
    @Override
    public List<Adoption> getAdoptionsByEmail(String email) {
        return adoptionPersistencePort.getAdoptionsByEmail(email);
    }

    /**
     * @param adoption to create
     * @return adoptionId
     */
    @Override
    public Long createAdoption(Adoption adoption) {
        return adoptionPersistencePort.createAdoption(adoption);
    }

    /**
     * @param adoptionId of adoption to update
     * @param adoption data updated
     * @return message of successfully update
     */
    @Override
    public String updateAdoption(Long adoptionId, Adoption adoption) {
        return adoptionPersistencePort.updateAdoption(adoptionId, adoption);
    }

    /**
     * @param adoptionId of adoption to deleted
     * @return boolean of a correct delete
     */
    @Override
    public boolean deleteAdoption(Long adoptionId) {
        return adoptionPersistencePort.deleteAdoption(adoptionId);
    }

    /**
     * @param emails
     * @return
     */
    @Override
    public Map<String, List<Adoption>> getAdoptionsByEmails(List<String> emails) {
        return adoptionPersistencePort.getAdoptionsByEmails(emails);
    }
}

