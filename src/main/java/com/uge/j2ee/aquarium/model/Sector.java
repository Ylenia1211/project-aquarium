package com.uge.j2ee.aquarium.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Sector.class)
public class Sector implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true,nullable = false)
    private Long id;
    private String name;
    private String localitation;

    @OneToMany(mappedBy = "poolSector", fetch = FetchType.EAGER)
    @JsonIdentityReference
    private Set<Pool> sectorPools = new HashSet<>();

    public Sector() {
    }
    public Sector(Long id, String name, String localitation, Set<Pool> sectorPools) {
        super();
        this.id = id;
        this.name = name;
        this.localitation = localitation;
        this.sectorPools= sectorPools;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalitation() {
        return localitation;
    }

    public void setLocalitation(String localitation) {
        this.localitation = localitation;
    }

    public Set<Pool> getSectorPools() {
        return sectorPools;
    }

    public void setSectorPools(Set<Pool> sectorPools) {
        this.sectorPools = sectorPools;
    }
}
