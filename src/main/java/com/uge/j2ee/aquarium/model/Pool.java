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
public class Pool implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPool;
    private String namePool;

    @ManyToOne
    @JoinColumn(name ="employee_pool_id")
    @JsonIdentityReference
    private Employee responsable;

    @ManyToOne
    @JoinColumn(name ="sector_pool_id")
    @JsonIdentityReference
    private Sector poolSector;


    @OneToMany(mappedBy = "pool", fetch = FetchType.EAGER)
    @JsonIdentityReference
    private Set<Animal> fishPool= new HashSet<>();

    @OneToMany(mappedBy = "poolActivity", fetch = FetchType.EAGER)
    @JsonIdentityReference
    private Set<Activity> activityPools = new HashSet<>();


    private Integer volume; //volume of water
    private String state; //propre o sale



    private String quantityFood;

    @ManyToOne
    @JoinColumn(name ="activity_pool_id")
    @JsonIdentityReference
    private Activity activity;

    public Pool() {
    }



    public Pool(Long id, String name, String state, Employee responsable, Integer volume, String quantityFood ) {
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
    public Pool(Long id, String name, String state) {
        super();
        this.idPool = id;
        this.namePool = name;
        this.state = state;
    }
    public Long getIdPool() {
        return idPool;
    }

    public void setIdPool(Long idPool) {
        this.idPool = idPool;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getNamePool() {
        return namePool;
    }

    public Employee getResponsable() {
        return responsable;
    }

    public void setResponsable(Employee responsable) {
        this.responsable = responsable;
    }

    public void setNamePool(String namePool) {
        this.namePool = namePool;
    }

    public Sector getPoolSector() {
        return poolSector;
    }

    public void setPoolSector(Sector poolSector) {
        this.poolSector = poolSector;
    }


    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
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

    public Set<Animal> getFishPool() {
        return fishPool;
    }

    public void setFishPool(Set<Animal> fishPool) {
        this.fishPool = fishPool;
    }
}
