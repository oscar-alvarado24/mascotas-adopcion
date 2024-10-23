package com.project.adoption.pet.domain.model;
import java.time.LocalDate;

public class Adoption {
    private Long id;

    private String email;

    private Long petId;

    private LocalDate dateAdoption;

    public Adoption() {
        //empty constructor to be used by the mapper
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public LocalDate getDateAdoption() {
        return dateAdoption;
    }

    public void setDateAdoption(LocalDate dateAdoption) {
        this.dateAdoption = dateAdoption;
    }
}

