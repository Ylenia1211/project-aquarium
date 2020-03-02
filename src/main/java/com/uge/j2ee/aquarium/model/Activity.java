package com.uge.j2ee.aquarium.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Activity.class)
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameActivity;
    private Date dataCal;
    //add time start and end
    private String state;

    @OneToMany(mappedBy = "activity")
    @JsonIdentityReference
    private Set<Pool> poolActivity = new HashSet<>();

    public Activity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameActivity() {
        return nameActivity;
    }

    public void setNameActivity(String nameActivity) {
        this.nameActivity = nameActivity;
    }

    public Date getDataCal() {
        return dataCal;
    }

    public void setDataCal(Date dataCal) {
        this.dataCal = dataCal;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<Pool> getPoolActivity() {
        return poolActivity;
    }

    public void setPoolActivity(Set<Pool> poolActivity) {
        this.poolActivity = poolActivity;
    }
}
