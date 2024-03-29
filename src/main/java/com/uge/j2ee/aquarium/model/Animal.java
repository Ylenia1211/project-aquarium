package com.uge.j2ee.aquarium.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true,nullable = false)
    private Long id;
    private String name;
    private String species;
    private String sex;
    private String feature;
    private boolean  extinction;
    private Date arrivalDate;
    private Date departureDate;
    private Integer lifeExpectancy;
    private String dietaryRegime;
    private short threatLevel;

    @ManyToOne
    @JoinColumn(name ="pool_animal_id")
    @JsonIdentityReference
    private Pool pool;

    public Animal() {
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    public Animal(Long id, String name, String species, String sex, String feature, boolean  extinction, Date arrivalDate, Date departureDate, Integer lifeExpectancy, String dietaryRegime, short threatLevel, Pool pool ) {
        super();
         this.id = id;
         this.name = name;
         this.species = species;
         this.sex = sex;
         this.feature = feature;
         this.extinction = extinction;
         this.arrivalDate = arrivalDate;
         this.departureDate = departureDate;
         this.lifeExpectancy = lifeExpectancy;
         this.dietaryRegime = dietaryRegime;
         this.threatLevel = threatLevel;
         this.pool = pool;
    }
    public Animal(String name, String species) {
        super();
        this.name = name;
        this.species = species;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Animal(Long id, String nom, String species) {
        super();
        this.id = id;
        this.name = name;
        this.species = species;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public boolean isExtinction() {
        return extinction;
    }

    public void setExtinction(boolean extinction) {
        this.extinction = extinction;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Integer lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public String getDietaryRegime() {
        return dietaryRegime;
    }

    public void setDietaryRegime(String dietaryRegime) {
        this.dietaryRegime = dietaryRegime;
    }

    public short getThreatLevel() {
        return threatLevel;
    }

    public void setThreatLevel(short threatLevel) {
        this.threatLevel = threatLevel;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((species == null) ? 0 : species.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (species == null) {
            if (other.species != null)
                return false;
        } else if (!species.equals(other.species))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", sex='" + sex + '\'' +
                ", feature='" + feature + '\'' +
                ", extinction=" + extinction +
                ", arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                ", lifeExpectancy=" + lifeExpectancy +
                ", dietaryRegime='" + dietaryRegime + '\'' +
                ", threatLevel=" + threatLevel +
                '}';
    }
}
