package com.project.pet.adoption.domain.repository;

import com.project.pet.adoption.domain.model.Adoption;

import java.util.List;
import java.util.Optional;

public interface AdoptionRepository {
    String save(Adoption adoption);
    Optional<Adoption> findById(Integer id);
    List<Adoption> findByEmails(List<String> emails);
    void deleteById(Integer id);

}
