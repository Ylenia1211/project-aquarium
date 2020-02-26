package com.uge.j2ee.aquarium.model;

import javax.persistence.*;
import java.util.List;

@Entity(name="animal_species")
public class AnimalSpecies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSpecies;

    @Column
    private String nameSpecies;
    @Column
    private String description;
    @Column
    private Integer numberAnimals;

    public AnimalSpecies() {
        this.numberAnimals=0;
    }

    public Long getIdSpecies() {
        return idSpecies;
    }

    public void setIdSpecies(Long idSpecies) {
        this.idSpecies = idSpecies;
    }

    public String getNameSpecies() {
        return nameSpecies;
    }

    public void setNameSpecies(String nameSpecies) {
        this.nameSpecies = nameSpecies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumberAnimals() {
        return numberAnimals;
    }

    public void setNumberAnimals(Integer numberAnimals) {
        this.numberAnimals = numberAnimals;
    }


}
