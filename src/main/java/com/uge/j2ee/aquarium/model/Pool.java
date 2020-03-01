package com.uge.j2ee.aquarium.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPool", scope = Pool.class)
public class Pool{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPool;
    private String namePool;

    @ManyToOne
    @JoinColumn(name ="employee_pool_id")
    @JsonIdentityReference
    private Employee responsable;

    private String volume; //volume of water
    private String state; //propre o sale

    public Employee getResponsable() {
        return responsable;
    }

    public void setResponsable(Employee responsable) {
        this.responsable = responsable;
    }

    /* @ManyToOne
        @JoinColumn("animal_id", nullable = false)
        private Animal fish;
      */
    private String quantityFood;
    //add Activity

    public Pool() {
    }
    public Pool(Long id, String name, String state, Employee responsable, String volume, String quantityFood ) {
        super();
        this.idPool = id;
        this.namePool = name;
        this.state = state;
        this.responsable= responsable;
        this.volume = volume;
        this.quantityFood = quantityFood;
    }
    public Pool(Long id, String name, String state, Employee responsable ) {
        super();
        this.idPool = id;
        this.namePool = name;
        this.state = state;
        this.responsable= responsable;
    }
    public Long getIdPool() {
        return idPool;
    }

    public void setIdPool(Long idPool) {
        this.idPool = idPool;
    }

    public String getNamePool() {
        return namePool;
    }

    public void setNamePool(String namePool) {
        this.namePool = namePool;
    }


    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getQuantityFood() {
        return quantityFood;
    }

    public void setQuantityFood(String quantityFood) {
        this.quantityFood = quantityFood;
    }
}
